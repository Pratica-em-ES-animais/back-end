package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import es.pratica.adocoes.dominio.modelos.OngModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Document
@NoArgsConstructor
public class OngEntity {
    @Id
    private String id;
    private String cnpj;
    private String name;
    private String email;
    private String ddd;
    private String phone;
    private AddressEntity addressEntity;


    public OngEntity(String cnpj, String name, String email, String ddd, String phone, AddressEntity addressEntity) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.addressEntity = addressEntity;
    }


    public static OngEntity fromModel(OngModel ongModel) {
        return new OngEntity(ongModel.getId(),ongModel.getCnpj(),ongModel.getName(),ongModel.getEmail(), 
        ongModel.getDdd(),ongModel.getPhone(),AddressEntity.fromModel(ongModel.getAddressModel()));
    }

}
