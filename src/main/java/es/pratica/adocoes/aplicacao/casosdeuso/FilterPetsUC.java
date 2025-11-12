package es.pratica.adocoes.aplicacao.casosdeuso;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.servicos.CompatibilityFilterService;

@Component
public class FilterPetsUC {
    private final CompatibilityFilterService filterService;

    public FilterPetsUC(CompatibilityFilterService filterService) {
        this.filterService = filterService;
    }

    public List<Map<String, Object>> execute(UserDto user, List<AnimalModel> pets, int topK){
        return filterService.filter(user, pets, topK);
    }
}
