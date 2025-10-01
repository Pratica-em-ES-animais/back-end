package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.OngDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.OngServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateOngUC {
    private final OngServiceInterface ongService;

    public OngDto createOng(OngDto ongDto){
        return OngDto.fromModel(this.ongService.createOng(OngDto.toModel(ongDto)));
    }
}
