package es.pratica.adocoes.aplicacao.dtos;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.AddressModel;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
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
    private String complemento;
    @Pattern(regexp = "[0-9]+")
    private String numero;
    @NonNull
    @Size(min = 1 , max = 100)
    private String logradouro;

    public static AddressDto fromModel(AddressModel addressModel) {
        return new AddressDto(addressModel.getCep(), addressModel.getUf(), addressModel.getCidade(),
                              addressModel.getBairro(), addressModel.getComplemento(),
                              addressModel.getNumero(), addressModel.getLogradouro());
    }

    public static AddressModel fromDto(AddressDto dto){
        return new AddressModel(dto.getCep(), dto.getUf(), dto.getCidade(), dto.getBairro(), 
                                dto.getComplemento(), dto.getNumero(), dto.getLogradouro());
    }

}
