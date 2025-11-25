// src/main/java/es/pratica/adocoes/aplicacao/casosdeuso/FilterPetsUC.java
package es.pratica.adocoes.aplicacao.casosdeuso;

import es.pratica.adocoes.aplicacao.dtos.PetCompatibilityDto;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.CompatibilityFilterServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterPetsUC {

    private final CompatibilityFilterServiceInterface filterService;

    public FilterPetsUC(CompatibilityFilterServiceInterface filterService) {
        this.filterService = filterService;
    }

    public List<PetCompatibilityDto> execute(UserDto user, List<AnimalModel> pets, int topK) {
        return filterService.filter(user, pets, topK);
    }
}
