package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AnimalEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.AnimalRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AnimalRepoMongo implements AnimalRepository {
    private final AnimalRepoInterface animalRepo;

    @Override
    public AnimalModel add(AnimalModel animalModel) {
        var response = this.animalRepo.save(AnimalEntity.fromModel(animalModel));
        return AnimalModel.toModel(response);
    }
    
    @Override
    public void removeAll(){
        this.animalRepo.deleteAll();
    }

    @Override
    public Optional<AnimalModel> getById(String id) {
        var response = this.animalRepo.findById(id);
        return response.map(AnimalModel::toModel);
    }

    @Override
    public Optional<AnimalModel> getByName(String name) {
        var response = this.animalRepo.findByName(name);
        return response.map(AnimalModel::toModel);
    }
}
