package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateAdoptionUC;
import es.pratica.adocoes.aplicacao.dtos.AdoptionDto;
import es.pratica.adocoes.dominio.modelos.AdoptionModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/adoption")
public class AdoptionController {
    private final CreateAdoptionUC createAdoptionUC;

    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<AdoptionDto> createAdoption(@RequestBody @Valid AdoptionDto adoptionDto){

        AdoptionModel adoptionModelResponse = this.createAdoptionUC.run(adoptionDto.getAnimalId(), adoptionDto.getAdopterId(), adoptionDto.getTutorId());

        AdoptionDto adoptionDtoResponse = AdoptionDto.fromModel(adoptionModelResponse);

        return new ResponseEntity<>(adoptionDtoResponse, HttpStatus.CREATED);
    }
}
