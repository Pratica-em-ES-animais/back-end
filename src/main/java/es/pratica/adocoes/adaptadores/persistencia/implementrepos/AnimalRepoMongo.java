package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import java.util.List;
import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AnimalEntity;
import es.pratica.adocoes.adaptadores.persistencia.entidades.StatusPetEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.AnimalRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AnimalRepoMongo implements AnimalRepository{
    private final AnimalRepoInterface animalRepo;

    @Override
    public List<AnimalModel> getAll() {
        return this.animalRepo.findAll().stream().map(AnimalModel::toModel).toList();
    }

    @Override
    public AnimalModel add(AnimalModel animalModel) {
        this.animalRepo.save(AnimalEntity.fromModel(animalModel));
        return animalModel;
    }

    @Override
    public List<AnimalModel> getByStatusPet(StatusPetModel statusPetModel) {
        return this.animalRepo.findByStatusPet(StatusPetEntity.valueOf(statusPetModel.name())).stream().map(AnimalModel::toModel).toList();
    }
}
