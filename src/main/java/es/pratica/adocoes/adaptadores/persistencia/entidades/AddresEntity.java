package es.pratica.adocoes.adaptadores.persistencia.entidades;

import com.mongodb.lang.NonNull;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddresEntity {
    @NonNull
    @Pattern(regexp = "[0-9]{8}")
    private String cep;
    @NonNull
    @Pattern(regexp = "[A-Z]{2}")
    private String uf;
    @NonNull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    @Size(min = 1 , max = 50)
    private String cidade;
    @NonNull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    @Size(min = 1 , max = 50)
    private String bairro;
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    private String complemento;
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    private String numero;
    @NonNull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\\\- ]+")
    @Size(min = 1 , max = 50)
    private String logradouro;
}
