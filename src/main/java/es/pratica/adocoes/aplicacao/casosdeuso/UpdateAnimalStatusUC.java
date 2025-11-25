package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.pratica.adocoes.aplicacao.dtos.UpdateAnimalStatusDto;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateAnimalStatusUC {

    private final AnimalRepository animalRepository;

    public AnimalModel run(UpdateAnimalStatusDto dto) {

        var animal = animalRepository.getById(dto.getAnimalId()).orElse(null);
        if (animal == null) {
            return null;
        }

        animal.setStatus(dto.getStatus());

        return animalRepository.update(animal);
    }
}
