package es.pratica.adocoes.aplicacao.casosdeuso;

import java.util.List;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.AnimalResponseDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class GetAnimalUC {
    private final AnimalServiceInterface animalService;

    public List<AnimalResponseDto> getAll(){
        return this.animalService.getAll().stream().map(AnimalResponseDto::fromModel).toList();
    }

}
