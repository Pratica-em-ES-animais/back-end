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
    @NonNull
    @Pattern(regexp = "[0-9]{11}")
    @Indexed(unique = true)
    private String cnpj;
    @NonNull
    @Size(min=1, max=60)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String name;
    @NonNull
    @Email
    private String email;
    @NonNull
    @Pattern(regexp = "[0-9]{2}")
    private String ddd;
    @NonNull
    @Pattern(regexp = "9\\d{8}")
    private String phone;
    @NonNull
    private AddressEntity addresEntity;

    public OngEntity(@Pattern(regexp = "[0-9]{11}") String cnpj,
            @Max(50) @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+") String name, @Email String email,
            @Pattern(regexp = "[0-9]{2}") String ddd, @Pattern(regexp = "[0-9]{9}") String phone,
            AddressEntity addresEntity) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.addresEntity = addresEntity;
    }

    public static OngEntity fromModel(OngModel ongModel) {
        return new OngEntity(ongModel.getId(),ongModel.getCnpj(),ongModel.getName(),ongModel.getEmail(), 
        ongModel.getDdd(),ongModel.getPhone(),AddressEntity.fromModel(ongModel.getAddressModel()));
    }

}
