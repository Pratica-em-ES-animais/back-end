// src/main/java/es/pratica/adocoes/adaptadores/controllers/FilterController.java
package es.pratica.adocoes.adaptadores.controllers;

import es.pratica.adocoes.aplicacao.casosdeuso.FilterPetsUC;
import es.pratica.adocoes.aplicacao.dtos.PetCompatibilityDto;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.enums.StatusPet;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.servicos.AnimalService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("api/filter")
@CrossOrigin(
    origins = "http://localhost:4200",
    allowCredentials = "true"
)
public class FilterController {

    private final FilterPetsUC useCase;
    private final AnimalService animalService;

    public FilterController(FilterPetsUC useCase, AnimalService animalService) {
        this.useCase = useCase;
        this.animalService = animalService;
    }

    @PostMapping
    public List<PetCompatibilityDto> filtrar(HttpServletRequest request) {
        UserDto user = (UserDto) request.getSession().getAttribute("user");

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não autenticado");
        }
        
        List<AnimalModel> pets = animalService.getAll().stream().filter(a -> a.getStatus() == StatusPet.AVAILABLE ).toList();
        return useCase.execute(user, pets, 3);
    }
}
