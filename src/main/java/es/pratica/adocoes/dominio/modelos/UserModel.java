package es.pratica.adocoes.dominio.modelos;


import es.pratica.adocoes.adaptadores.persistencia.entidades.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UserModel {
    private String id;
    private String cpf;
    private String firstName;
    private String lastName;
    private String email;
    private String ddd;
    private String phone;
    private String senha;



    public UserModel(String cpf, String firstName, String lastName, String email, String ddd, String phone, String senha){
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.senha = senha;
    }



    public static UserModel toModel(UserEntity ue){
       return new UserModel(ue.getId(), ue.getCpf(), ue.getFirstName(),ue.getLastName(), ue.getEmail(), ue.getDdd(),ue.getPhone(), ue.getSenha());
    }


}

