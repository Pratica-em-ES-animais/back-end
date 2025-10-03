package es.pratica.adocoes.adaptadores.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateAnimalUC;
import es.pratica.adocoes.aplicacao.casosdeuso.GetAnimalUC;
import es.pratica.adocoes.aplicacao.dtos.AnimalDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/animal")
public class AnimalController {
    private final CreateAnimalUC createAnimalUC;
    private final GetAnimalUC getAnimalUC;

    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody @Valid AnimalDto animalDto){
        if(this.createAnimalUC.run(animalDto) == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(animalDto, HttpStatus.CREATED);
    }

    @GetMapping("/pets")
    @CrossOrigin("*")
    public ResponseEntity<List<AnimalDto>> getAll(){
        return new ResponseEntity<>(this.getAnimalUC.getAll(), HttpStatus.OK);
    }
}
