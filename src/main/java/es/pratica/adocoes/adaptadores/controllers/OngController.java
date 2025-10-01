package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateOngUC;
import es.pratica.adocoes.aplicacao.dtos.OngDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ong")
public class OngController {
    private final CreateOngUC createOngUC;

    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<OngDto> createOng(@RequestBody OngDto dto){
        if(this.createOngUC.createOng(dto) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
}
