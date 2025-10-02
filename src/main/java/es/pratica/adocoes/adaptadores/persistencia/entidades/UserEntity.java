package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;
    private String cpf;
    private String firstName;
    private String lastName;
    private String email; 
    private String ddd;
    private String phone;
    private String senha;

    public static UserEntity fromModel(UserModel model){
        return new UserEntity(model.getId(), model.getCpf(), model.getFirstName(), 
                                model.getLastName(), model.getEmail(), model.getDdd(), model.getPhone(), model.getSenha());
    }
}
