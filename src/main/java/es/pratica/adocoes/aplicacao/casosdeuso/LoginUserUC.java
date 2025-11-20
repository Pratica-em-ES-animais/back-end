package es.pratica.adocoes.aplicacao.casosdeuso;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.DetailsBaseDTO;
import es.pratica.adocoes.aplicacao.dtos.TutorDetailsDTO;
import es.pratica.adocoes.aplicacao.dtos.UserDetailsDTO;
import es.pratica.adocoes.aplicacao.dtos.TutorResponseDto;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.aplicacao.dtos.UserLoginDto;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.TutorService;
import es.pratica.adocoes.dominio.servicos.UserService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LoginUserUC {
    private final UserService userService;
    private final TutorService tutorService;
    private final PasswordEncoder passwordEncoder;

    public DetailsBaseDTO login(UserLoginDto dto){
        Optional<UserModel> resp = this.userService.getByEmail(dto.getEmail());
        if(!resp.isEmpty()){
            UserDto user = UserDto.fromModel(resp.get());
            if(!passwordEncoder.matches(dto.getSenha(), user.getSenha())){
                return null;
            }
            return new UserDetailsDTO(user.getId(), user.getRole(),
            user.getFirstName(), user.getLastName(), user.getLifestyle(), user.getPreferences());

        }
        Optional<TutorModel> response = this.tutorService.getByEmail(dto.getEmail());
        if(response.isEmpty()){
            return null;
        }
        TutorModel tutor = response.get();
        if(!passwordEncoder.matches(dto.getSenha(), tutor.getSenha())){
            return null;
        }
        return new TutorDetailsDTO(tutor.getId(), tutor.getRole(), tutor.getFirstName(), tutor.getLastName());
    }

}
