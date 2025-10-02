package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.pratica.adocoes.aplicacao.casosdeuso.CreateTutorUC;
import es.pratica.adocoes.aplicacao.dtos.TutorCreateDto;
import es.pratica.adocoes.aplicacao.dtos.TutorResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tutor")
public class TutorController {
    private final CreateTutorUC createTutorUC;

    @PostMapping("/create")
    public ResponseEntity<TutorResponseDto> createTutor(@Valid @RequestBody TutorCreateDto dto){
        TutorResponseDto response = this.createTutorUC.createTutor(dto); 
        if(response == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

}
