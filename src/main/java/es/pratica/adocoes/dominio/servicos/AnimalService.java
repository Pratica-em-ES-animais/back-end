package es.pratica.adocoes.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInteface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnimalService implements AnimalServiceInteface{
    private final AnimalRepository animalRepository;

    @Override
    public List<AnimalModel> getAll() {
        return this.animalRepository.getAll();
    }

    @Override
    public AnimalModel add(AnimalModel animalModel) {
        return this.animalRepository.add(animalModel);
    }

    @Override
    public List<AnimalModel> getByStatusPet(StatusPetModel statusPetModel) {
        return this.animalRepository.getByStatusPet(statusPetModel);
    }
    
}
