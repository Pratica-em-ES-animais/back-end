package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.enums.StatusPet;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UpdateAnimalStatusUC {

    private final AnimalRepository animalRepository;

    public AnimalModel run(String animalId, StatusPet newStatus) {

        var animal = animalRepository.getById(animalId).orElse(null);
        if (animal == null) {
            return null;
        }

        animal.setStatus(newStatus);

        return animalRepository.update(animal);
    }
}
