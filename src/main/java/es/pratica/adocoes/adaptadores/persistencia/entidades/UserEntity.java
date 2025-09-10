package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class UserEntity {
    @Id
    private String id;
    @NonNull
    private String cpf;
    @NonNull
    private String primeiroNome;
    @NonNull
    private String sobrenome;

    public static UserEntity fromModel(UserModel model){
        return new UserEntity(model.getId(), model.getCpf(), model.getPrimeiroNome(), model.getSobrenome());
    }
}
