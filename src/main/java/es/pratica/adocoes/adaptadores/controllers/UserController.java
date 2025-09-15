package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateUserUC;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user/")
public class UserController {
    private final CreateUserUC createUserUC;

    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<UserDto> createUser(@RequestBody() UserDto us){
        if(this.createUserUC.run(us) == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(us,HttpStatus.CREATED);
    }
}
