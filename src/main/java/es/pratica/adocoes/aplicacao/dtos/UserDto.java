package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String id;
    private String cpf;
    private String primeiroNome;
    private String sobrenome;

    public UserDto(){}

    public UserDto(String cpf,String primeiroNome, String sobrenome){
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
    }

    public static UserDto fromModel(UserModel model){
        return new UserDto(model.getId(), model.getCpf(), model.getPrimeiroNome(), model.getSobrenome());
    }

    public static UserModel toModel(UserDto dto){ 
        return new UserModel(dto.getCpf(), dto.getPrimeiroNome(),dto.getSobrenome());
    }

}
