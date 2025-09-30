package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class TutorEntity {
    @Id
    private String id;
    @NonNull
    @Pattern(regexp = "[0-9]{11}")
    private String cpf;
    @NonNull
    @Max(50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    private String firstName;
    @NonNull
    @Max(50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    private String lastName;
    @NonNull
    @Email
    private String email;
    @Pattern(regexp = "[0-9]{2}")
    @NonNull
    private String ddd;
    @NonNull
    @Pattern(regexp = "[0-9]{9}")
    private String phone;
    private String senha;
    @DBRef
    private OngEntity ongEntity;
}
