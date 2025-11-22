package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin("*")
    public ResponseEntity<?> createTutor(@Valid @RequestBody TutorCreateDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String erro = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(erro);
        }
        TutorResponseDto response = this.createTutorUC.createTutor(dto); 
        if(response == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

}
