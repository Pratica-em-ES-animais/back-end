package es.pratica.adocoes.adaptadores.controllers;

import es.pratica.adocoes.aplicacao.casosdeuso.LoginUserUC;
import es.pratica.adocoes.aplicacao.dtos.DetailsBaseDTO;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.aplicacao.dtos.UserLoginDto;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true"
)
public class AuthController {

    private final LoginUserUC loginUserUC;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto dto, HttpSession session) {
        DetailsBaseDTO details = this.loginUserUC.login(dto);
        if (details == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        // Monta um UserDto mínimo só pra IA (ajusta se quiser mais campos)
        UserDto userSession = new UserDto();
        userSession.setId(details.getId());
        userSession.setFirstName(details.getFirstName());
        userSession.setLastName(details.getLastName());
        userSession.setRole(details.getRole());
        userSession.setLifestyle("Not provided");
        userSession.setPreferences("Not provided");

        // SALVA NA SESSÃO
        session.setAttribute("user", userSession);

        System.out.println("Login OK, salvando user na sessão: " + userSession.getId());

        // continua devolvendo DetailsBaseDTO pro front
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
