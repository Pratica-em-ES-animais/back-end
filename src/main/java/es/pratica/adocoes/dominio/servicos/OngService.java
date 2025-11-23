package es.pratica.adocoes.dominio.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.interfacerepositorios.OngRepository;
import es.pratica.adocoes.dominio.modelos.OngModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.OngServiceInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OngService implements OngServiceInterface {

    private final OngRepository ongRepo;

    @Override
    public OngModel createOng(OngModel ong) {
        if(this.ongRepo.getByCnpj(ong.getCnpj()).isPresent()){
            return null;
        }
        return this.ongRepo.add(ong);
    }

    @Override
    public OngModel getByCnpj(String cnpj) {
        var response = this.ongRepo.getByCnpj(cnpj);
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }

    @Override
    public List<OngModel> getAll() {
        return this.ongRepo.getAll();
    }
    
}
