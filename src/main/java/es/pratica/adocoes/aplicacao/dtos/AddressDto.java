package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.modelos.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
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
