package es.pratica.adocoes.aplicacao.casosdeuso;

import java.util.List;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.OngResponseDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.OngServiceInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ListOngsUC {
    private final OngServiceInterface ongService;

    public List<OngResponseDto> getAll(){
        return this.ongService.getAll().stream().map(OngResponseDto::fromModel).toList();
    }
}
