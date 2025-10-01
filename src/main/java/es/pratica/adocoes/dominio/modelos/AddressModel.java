package es.pratica.adocoes.dominio.modelos;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressModel{
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String logradouro;

    public static AddressModel toModel(AddressEntity addressEntity) {
        return new AddressModel(addressEntity.getCep(), addressEntity.getUf(),
        addressEntity.getCidade(), addressEntity.getBairro(),
        addressEntity.getComplemento(), addressEntity.getNumero(), addressEntity.getLogradouro());
    }
}
