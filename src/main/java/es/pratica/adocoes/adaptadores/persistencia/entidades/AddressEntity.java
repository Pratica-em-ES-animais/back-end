package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.AddressModel;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Document
@NoArgsConstructor
public class AddressEntity {
    @NonNull
    @Pattern(regexp = "[0-9]{8}")
    private String cep;
    @NonNull
    @Pattern(regexp = "[A-Z]{2}")
    private String uf;
    @NonNull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    @Size(min = 1 , max = 50)
    private String cidade;
    @NonNull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    @Size(min = 1 , max = 50)
    private String bairro;
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String complemento;
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String numero;
    @NonNull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    @Size(min = 1 , max = 50)
    private String logradouro;


    public static AddressEntity fromModel(AddressModel addressModel) {
        return new AddressEntity(addressModel.getCep(), addressModel.getUf(), addressModel.getCidade(), 
            addressModel.getBairro(), addressModel.getComplemento(), addressModel.getNumero(), addressModel.getLogradouro());
    }
}
