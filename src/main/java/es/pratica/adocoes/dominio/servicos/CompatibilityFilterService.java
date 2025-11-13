package es.pratica.adocoes.dominio.servicos;

import es.pratica.adocoes.dominio.servicos.interfaceservice.CompatibilityFilterServiceInterface;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CompatibilityFilterService implements CompatibilityFilterServiceInterface {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Map<String, Object>> filter(UserDto userProfile, List<AnimalModel> pets, int topN) {
        try {
            // Montar prompt
            String prompt = String.format("""
You are an assistant that compares a user's profile with a list of pets.
Each pet has attributes like id, size, energy, temperament, and good_with_kids.
The user has preferences for size, energy, children, etc.

Compare each pet to the user and assign a match_score between 0 and 1.
Output a JSON array of objects, each containing "id" and "match_score", sorted by descending score.
Only output valid JSON.

User profile: %s
Pets: %s
""", objectMapper.writeValueAsString(userProfile), objectMapper.writeValueAsString(pets));

            // Montar corpo da requisição
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

            // Limpar markdown se vier com ```
            jsonText = jsonText.replaceAll("```json", "").replaceAll("```", "").trim();

            // Parsear JSON
            List<Map<String, Object>> matches = objectMapper.readValue(
                    jsonText,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class)
            );

            return matches.subList(0, Math.min(topN, matches.size()));

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
