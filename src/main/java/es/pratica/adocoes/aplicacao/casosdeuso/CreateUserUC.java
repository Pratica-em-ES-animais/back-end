package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.UserServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateUserUC {
    private final UserServiceInterface cadastrarService;
    
    public UserDto run(UserDto us){
        System.out.println("aqui!");
        if(cadastrarService.getByEmail(us.getEmail()).isEmpty()){
            return UserDto.fromModel(cadastrarService.createUser(UserDto.toModel(us)));
        }
        return null;
    }

}
