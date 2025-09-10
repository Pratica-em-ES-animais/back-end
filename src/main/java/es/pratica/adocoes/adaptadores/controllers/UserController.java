package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.pratica.adocoes.aplicacao.casosdeuso.CriarUsuarioUC;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    private final CriarUsuarioUC criarUsuarioUC;

    @PostMapping("/api/criarUsuario")
    @CrossOrigin("*")
    public UserDto criarUsuario(@RequestBody() UserDto us){
        return criarUsuarioUC.run(us);
    }
}
