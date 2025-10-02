package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorEntity {
    @Id
    private String id;
    private String cpf;
    private String firstName;
    private String lastName;
    private String email;
    private String ddd;
    private String phone;
    private String senha;
    @DBRef
    private OngEntity ongEntity;

    public static TutorEntity fromModel(TutorModel tutorModel){
        return new TutorEntity(tutorModel.getId(), tutorModel.getCpf(), tutorModel.getFirstName(), tutorModel.getLastName(), tutorModel.getEmail(),tutorModel.getDdd(),tutorModel.getPhone(),tutorModel.getSenha(), OngEntity.fromModel(tutorModel.getOngModel()));
    }
}
