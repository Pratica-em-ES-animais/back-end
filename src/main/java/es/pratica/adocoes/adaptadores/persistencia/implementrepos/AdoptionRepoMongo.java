package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AdoptionEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.AdoptionRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.AdoptionRepository;
import es.pratica.adocoes.dominio.modelos.AdoptionModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AdoptionRepoMongo implements AdoptionRepository {
    private final AdoptionRepoInterface adoptionRepo;

    @Override
    public void removeAll() {
        this.adoptionRepo.deleteAll();
    }

    @Override
    public AdoptionModel add(AdoptionModel adoptionModel) {
        var response = this.adoptionRepo.save(AdoptionEntity.fromModel(adoptionModel));
        return AdoptionModel.reconstitute(
            response.getId(),
            response.getAnimalId(),
            response.getTutorId(),
            response.getAdopterId(),
            response.getRequestDateTime(),
            response.getStatus()
        );
    }


}
