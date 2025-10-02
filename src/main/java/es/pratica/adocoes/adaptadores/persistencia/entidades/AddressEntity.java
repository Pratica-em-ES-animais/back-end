package es.pratica.adocoes.adaptadores.persistencia.entidades;

import es.pratica.adocoes.dominio.modelos.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressEntity {
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String logradouro;


    public static AddressEntity fromModel(AddressModel addressModel) {
        return new AddressEntity(addressModel.getCep(), addressModel.getUf(), addressModel.getCidade(), 
            addressModel.getBairro(), addressModel.getComplemento(), addressModel.getNumero(), addressModel.getLogradouro());
    }
}
