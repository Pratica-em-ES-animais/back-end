package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateOngUC;
import es.pratica.adocoes.aplicacao.casosdeuso.ListOngsUC;
import es.pratica.adocoes.aplicacao.dtos.OngDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ong")
public class OngController {
    private final CreateOngUC createOngUC;
    private final ListOngsUC listOngUc;
    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<?> createOng(@RequestBody @Valid OngDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String erro = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(erro);
        }
        
        if(this.createOngUC.createOng(dto) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @GetMapping("")
    @CrossOrigin("*")
    public ResponseEntity<?> getAll() throws Exception{
        try{
            return new ResponseEntity<>(this.listOngUc.getAll(), HttpStatus.OK);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
