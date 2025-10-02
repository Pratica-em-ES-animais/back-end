package es.pratica.adocoes.dominio.servicos;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInterface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AnimalService implements AnimalServiceInterface {
    private final AnimalRepository animalRepositorio;

    @Override
    public AnimalModel createAnimal(AnimalModel animalModel){
        return this.animalRepositorio.add(animalModel);
    }

    @Override
    public void removeAll(){
        this.animalRepositorio.removeAll();
    }

    @Override
    public Optional<AnimalModel> getById(String id) {
        return this.animalRepositorio.getById(id);
    }

    @Override
    public Optional<AnimalModel> getByName(String name) {
        return this.animalRepositorio.getByName(name);
    }
}
