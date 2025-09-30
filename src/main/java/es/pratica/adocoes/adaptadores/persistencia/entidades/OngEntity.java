package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OngEntity {
    @Id
    private String id;
    @NonNull
    @Pattern(regexp = "[0-9]{11}")
    private String cnpj;
    @NonNull
    @Max(50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    private String name;
    @NonNull
    @Email
    private String email;
    @NonNull
    @Pattern(regexp = "[0-9]{2}")
    private String ddd;
    @NonNull
    @Pattern(regexp = "[0-9]{9}")
    private String phone;
    private AddresEntity addresEntity;

}
