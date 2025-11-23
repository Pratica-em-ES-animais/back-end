package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.pratica.adocoes.aplicacao.casosdeuso.CreateUserUC;
import es.pratica.adocoes.aplicacao.dtos.DetailsBaseDTO;
import es.pratica.adocoes.aplicacao.dtos.UserDetailsDTO;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final CreateUserUC createUserUC;

    @PostMapping("/create")
    @CrossOrigin("*")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDto us, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String erro = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(erro);
        }
        var response = this.createUserUC.run(us);
        if( response == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        var resp = new DetailsBaseDTO(response.getId(), response.getRole(), response.getFirstName(), response.getLastName());
        return new ResponseEntity<>(resp,HttpStatus.CREATED);
    }

}
