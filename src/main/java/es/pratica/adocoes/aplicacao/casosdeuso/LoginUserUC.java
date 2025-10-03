package es.pratica.adocoes.aplicacao.casosdeuso;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.aplicacao.dtos.UserLoginDto;
import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.UserService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LoginUserUC {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserDto login(UserLoginDto dto ){
        Optional<UserModel> resp = this.userService.getByEmail(dto.getEmail());
        if(resp.isEmpty()){
            return null;
        }
        UserDto user = UserDto.fromModel(resp.get());
        if(!passwordEncoder.matches(dto.getSenha(), user.getSenha())){
            return null;
        }
        return user;

    }

}
