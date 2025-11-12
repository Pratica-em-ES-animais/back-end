package es.pratica.adocoes.adaptadores.controllers;

import es.pratica.adocoes.aplicacao.casosdeuso.FilterPetsUC;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import es.pratica.adocoes.dominio.servicos.AnimalService;
@RestController
@RequestMapping("api/filter")
public class FilterController {

    private final FilterPetsUC useCase;
    private final AnimalService animalService;

    public FilterController(FilterPetsUC useCase, AnimalService animalService) {
        this.useCase = useCase;
        this.animalService = animalService;
    }

    @PostMapping
    public List<Map<String, Object>> filtrar() {
        // simular usuário logado (substituir depois por SecurityContext)
        UserDto userMock = new UserDto("02783985020", "rafa", "franca", "rafa@franca.com", "51", "999999999", "senha123");
        
        // get all dos pets
        List<AnimalModel> pets = animalService.getAll();
        
        return useCase.execute(userMock, pets, 3);
    }
}
