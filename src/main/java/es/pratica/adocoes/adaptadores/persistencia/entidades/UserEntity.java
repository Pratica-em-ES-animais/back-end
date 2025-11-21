package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.pratica.adocoes.dominio.enums.Role;
import es.pratica.adocoes.dominio.modelos.UserModel;
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
    private String lifestyle;
    private String preferences;
    private Role role;

    public static UserEntity fromModel(UserModel model){
        return new UserEntity(model.getId(), model.getCpf(), model.getFirstName(), 
                                model.getLastName(), model.getEmail(), model.getDdd(), model.getPhone(), model.getSenha(), 
                                model.getLifestyle(), model.getPreferences(), model.getRole());
    }
}
