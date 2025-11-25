// src/main/java/es/pratica/adocoes/dominio/servicos/CompatibilityFilterService.java
package es.pratica.adocoes.dominio.servicos;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.pratica.adocoes.aplicacao.dtos.PetCompatibilityDto;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.CompatibilityFilterServiceInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CompatibilityFilterService implements CompatibilityFilterServiceInterface {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // DTO interno para mapear a resposta da OpenAI
    private static class MatchResponse {
        public String id;
        public double match_score;
    }

    @Override
    public List<PetCompatibilityDto> filter(UserDto userProfile, List<AnimalModel> pets, int topN) {
        try {
            // Montar prompt
            String prompt = String.format("""
You are a pet adoption specialist that analyzes compatibility between users and pets for adoption.

ANALYSIS CRITERIA:
1. User's LIFESTYLE: Consider their living situation, daily routine, experience with pets, family composition, available time, and financial situation.
2. User's PREFERENCES: Consider their desired pet characteristics, size, energy level, temperament, and specific requirements.
3. Pet CHARACTERISTICS: Consider each pet's species, size, energy level, temperament, sociability, health status, and special needs.

MATCHING PROCESS:
- Analyze how well each pet's needs align with the user's lifestyle
- Consider if the user's preferences match the pet's characteristics
- Factor in practical compatibility (living space, activity level, experience needed)
- Consider long-term sustainability of the match

SCORING:
Assign a match_score between 0.0 and 1.0 where:
- 0.8-1.0: Excellent match (highly compatible)
- 0.6-0.8: Good match (compatible with minor considerations)
- 0.4-0.6: Fair match (some concerns but workable)
- 0.0-0.4: Poor match (significant incompatibilities)

OUTPUT: JSON array of objects with "id" and "match_score", sorted by descending score.
Only output valid JSON, no explanations.

USER LIFESTYLE: %s
USER PREFERENCES: %s
AVAILABLE PETS: %s
""",
                    userProfile.getLifestyle() != null ? userProfile.getLifestyle() : "Not provided",
                    userProfile.getPreferences() != null ? userProfile.getPreferences() : "Not provided",
                    objectMapper.writeValueAsString(pets)
            );

            // Corpo da requisição
            Map<String, Object> body = Map.of(
                    "model", "gpt-4o-mini",
                    "messages", List.of(
                            Map.of("role", "system", "content", "You are an assistant that outputs only JSON."),
                            Map.of("role", "user", "content", prompt)
                    ),
                    "temperature", 0,
                    "seed", 1
            );

            // Headers HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(openAiApiKey);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response = restTemplate.exchange(
                    "https://api.openai.com/v1/chat/completions",
                    HttpMethod.POST,
                    request,
                    String.class
            );

            // Extrair conteúdo
            String jsonText = objectMapper.readTree(response.getBody())
                    .path("choices").get(0)
                    .path("message").path("content").asText();

            // Limpar markdown se vier com ```json
            jsonText = jsonText
                    .replace("```json", "")
                    .replace("```", "")
                    .trim();

            // Parsear JSON direto para a classe MatchResponse (sem Map)
            List<MatchResponse> matches = objectMapper.readValue(
                    jsonText,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, MatchResponse.class)
            );

            // Mapear pets por id para acesso rápido
            Map<String, AnimalModel> petsById = pets.stream()
                    .filter(p -> p.getId() != null)
                    .collect(Collectors.toMap(AnimalModel::getId, Function.identity()));

            // Converter MatchResponse -> PetCompatibilityDto
            List<PetCompatibilityDto> result = new ArrayList<>();
            for (MatchResponse match : matches) {
                if (match.id == null) continue;
                AnimalModel pet = petsById.get(match.id);
                if (pet == null) continue; // ignora ids que não existem

                result.add(new PetCompatibilityDto(pet, match.match_score));
            }

            // Ordenar por score desc, garantir topN
            result.sort(Comparator.comparingDouble(PetCompatibilityDto::score).reversed());
            if (result.size() > topN) {
                return result.subList(0, topN);
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
