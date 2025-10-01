package es.pratica.adocoes.dominio.modelos;

import es.pratica.adocoes.adaptadores.persistencia.entidades.OngEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OngModel {
    private String id;
    private String cnpj;
    private String name;
    private String email;
    private String ddd;
    private String phone;
    private AddressModel addressModel;

    public OngModel(String cnpj, String name, String email, String ddd, String phone, AddressModel addressModel){
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;   
        this.addressModel = addressModel;
    }

    public static OngModel toModel(OngEntity ongEntity) {
        return new OngModel(ongEntity.getId(), ongEntity.getCnpj(), ongEntity.getName(), ongEntity.getEmail(), 
                ongEntity.getDdd(), ongEntity.getPhone(), AddressModel.toModel(ongEntity.getAddressEntity()));
    }
}
