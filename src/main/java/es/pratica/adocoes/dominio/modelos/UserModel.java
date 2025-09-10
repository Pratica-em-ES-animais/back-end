package es.pratica.adocoes.dominio.modelos;


import es.pratica.adocoes.adaptadores.persistencia.entidades.UserEntity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserModel {
    private String id;
    private String cpf;
    private String primeiroNome;
    private String sobrenome;

    
    public UserModel(String id, String cpf, String primeiroNome, String sobrenome){
        this.id = id;
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
    }

    public UserModel(String cpf, String primeiroNome, String sobrenome){
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
    }



    public static UserModel toModel(UserEntity ue){
       return new UserModel(ue.getId(), ue.getCpf(), ue.getPrimeiroNome(),ue.getSobrenome());
    }


}

