package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import java.util.List;
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
        var saved = animalRepo.save(AnimalEntity.fromModel(animalModel));
        return AnimalModel.toModel(saved);
    }

    @Override
    public Optional<AnimalModel> getById(String id) {
        return animalRepo.findById(id)
                         .map(AnimalModel::toModel);
    }

    @Override
    public Optional<AnimalModel> getByName(String name) {
        return animalRepo.findByName(name)
                         .map(AnimalModel::toModel);
    }

    @Override
    public List<AnimalModel> getAll() {
        return animalRepo.findAll()
                         .stream()
                         .map(AnimalModel::toModel)
                         .toList();
    }

    @Override
    public void removeAll() {
        animalRepo.deleteAll();
    }

    @Override
    public AnimalModel update(AnimalModel animalModel) {
        var saved = animalRepo.save(AnimalEntity.fromModel(animalModel));
        return AnimalModel.toModel(saved);
    }

    @Override
    public void removeById(String id) {
        animalRepo.deleteById(id);
    }
}
