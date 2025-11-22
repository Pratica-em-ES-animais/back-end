package es.pratica.adocoes.adaptadores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.pratica.adocoes.aplicacao.casosdeuso.LoginUserUC;
import es.pratica.adocoes.aplicacao.dtos.DetailsBaseDTO;
import es.pratica.adocoes.aplicacao.dtos.UserLoginDto;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final LoginUserUC loginUserUC;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<?> login(@RequestBody UserLoginDto dto, HttpSession request){
        DetailsBaseDTO userDto = this.loginUserUC.login(dto);
        if(userDto == null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        request.setAttribute("user", userDto);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    } 
}
