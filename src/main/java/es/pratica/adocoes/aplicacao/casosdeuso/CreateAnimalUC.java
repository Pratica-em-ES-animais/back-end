package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.AnimalDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateAnimalUC {
    private final AnimalServiceInterface animalService;
    
    public AnimalDto run(AnimalDto animalDto){
        // aqui poderia ter alguma regra de negócio antes de salvar
        return AnimalDto.fromModel(
            animalService.createAnimal(AnimalDto.toModel(animalDto))
        );
    }
}
