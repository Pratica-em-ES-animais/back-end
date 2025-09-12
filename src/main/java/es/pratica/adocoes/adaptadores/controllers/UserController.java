package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CreateUserUC;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    private final CreateUserUC createUserUC;

    @PostMapping("/api/createUser")
    @CrossOrigin("*")
    public UserDto createUser(@RequestBody() UserDto us){
        return createUserUC.run(us);
    }
}
