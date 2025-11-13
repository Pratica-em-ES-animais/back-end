package es.pratica.adocoes.adaptadores.controllers;

import es.pratica.adocoes.aplicacao.casosdeuso.FilterPetsUC;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import es.pratica.adocoes.dominio.servicos.AnimalService;
import jakarta.servlet.http.HttpServletRequest;


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
    public List<Map<String, Object>> filtrar(HttpServletRequest request) {
        // simular usuário logado (substituir depois por SecurityContext)
        //UserDto userMock = new UserDto("02783985020", "rafa", "franca", "rafa@franca.com", "51", "999999999", "senha123");
        
        UserDto user = (UserDto) request.getSession().getAttribute("user");
        
        if(user == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não autenticado");
        }

        // get all dos pets
        List<AnimalModel> pets = animalService.getAll();
        
        return useCase.execute(user, pets, 3);
    }
}
