package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String id;
    private String cpf;
    private String firstName;
    private String lastName;
    private String email;
    private String ddd;
    private String phone;
    private String senha;

    public UserDto(){}

    public UserDto(String cpf,String firstName, String lastName, String email, String ddd, String phone, String senha) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.senha = senha;
    }

    // retrieving an user
    public static UserDto fromModel(UserModel model){
        return new UserDto(model.getId(), model.getCpf(), model.getFirstName(), model.getLastName(), model.getEmail(), model.getDdd(), model.getCpf(), model.getSenha());
    }

    // creating an user
    public static UserModel toModel(UserDto dto){ 
        return new UserModel(dto.getCpf(), dto.getFirstName(),dto.getLastName(), dto.getEmail(), dto.getDdd(), dto.getPhone(), dto.getSenha());
    }

}
