package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.servicos.UserService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateUserUC {
    private final UserService cadastrarService;
    
    public UserDto run(UserDto us){
        return UserDto.fromModel(cadastrarService.createUser(UserDto.toModel(us)));
    }

}
