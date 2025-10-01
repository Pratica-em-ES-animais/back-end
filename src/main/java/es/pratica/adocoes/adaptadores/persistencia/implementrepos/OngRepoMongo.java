package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.OngEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.OngRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.OngRepository;
import es.pratica.adocoes.dominio.modelos.OngModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class OngRepoMongo implements OngRepository {
    
    private final OngRepoInterface ongRepo;

    @Override
    public OngModel add(OngModel ongModel) {
        this.ongRepo.save(OngEntity.fromModel(ongModel));
        return ongModel;
    }

    @Override
    public Optional<OngModel> getByCnpj(String cnpj) {
        var response = this.ongRepo.findByCnpj(cnpj);
        if(response.isPresent()){
            return response.map(OngModel::toModel);
        }
        return Optional.empty();
    }
    
}
