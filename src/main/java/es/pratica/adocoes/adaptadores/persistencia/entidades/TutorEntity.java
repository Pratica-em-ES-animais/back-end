package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.TutorModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NonNull
    @Pattern(regexp = "[0-9]{11}")
    @Indexed(unique = true)
    private String cpf;
    @NonNull
    @Size(min=1, max=50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String firstName;
    @NonNull
    @Size(min=1, max=50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String lastName;
    @NonNull
    @Email
    private String email;
    @Pattern(regexp = "[0-9]{2}")
    @NonNull
    private String ddd;
    @NonNull
    @Pattern(regexp = "9\\d{8}")
    private String phone;
    private String senha;
    @DBRef
    private OngEntity ongEntity;

    public static TutorEntity fromModel(TutorModel tutorModel){
        return new TutorEntity(tutorModel.getId(), tutorModel.getCpf(), tutorModel.getFirstName(), tutorModel.getLastName(), tutorModel.getEmail(),tutorModel.getDdd(),tutorModel.getPhone(),tutorModel.getSenha(), OngEntity.fromModel(tutorModel.getOngModel()));
    }
}
