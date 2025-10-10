package es.pratica.adocoes.dominio.servicos;

import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.interfacerepositorios.AdoptionRepository;
import es.pratica.adocoes.dominio.modelos.AdoptionModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AdoptionServiceInterface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdoptionService implements AdoptionServiceInterface {
    private final AdoptionRepository adoptionRepositorio;

    @Override
    public AdoptionModel createAdoption(AdoptionModel adoptionModel){
        return this.adoptionRepositorio.add(adoptionModel);
    }

    @Override
    public void removeAll(){
        this.adoptionRepositorio.removeAll();
    }
    
}
