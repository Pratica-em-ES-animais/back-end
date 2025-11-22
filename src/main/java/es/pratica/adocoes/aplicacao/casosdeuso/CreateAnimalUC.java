package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.AnimalCreateDto;
import es.pratica.adocoes.aplicacao.dtos.AnimalResponseDto;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateAnimalUC {
    private final AnimalServiceInterface animalService;
    private AnimalRepository animalRepository;
    
    public AnimalResponseDto run(AnimalCreateDto animalCreateDto){
        // aqui poderia ter alguma regra de negócio antes de salvar
        return AnimalResponseDto.fromModel(
            animalService.createAnimal(AnimalCreateDto.toModel(animalCreateDto))
        );
    }

    public void attachPhotoToAnimal(String id, String filename) {

        // Buscar animal no repositório
        AnimalModel animal = animalRepository.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Animal not found"));

        // Atualizar a fotoa
        animal.setPhoto(filename);

        // Salvar alterações
        animalRepository.add(animal); // ou update(animal), dependendo da sua implementação
    }



}
