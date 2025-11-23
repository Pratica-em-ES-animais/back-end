package es.pratica.adocoes.aplicacao.dtos;


import org.springframework.data.mongodb.core.index.Indexed;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.OngModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OngDto {
     private String id;
    @NonNull
    @Pattern(regexp = "[0-9]{14}")
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
    private AddressDto addressDto;

    public OngDto(String cnpj, String name, String email, String ddd, String phone, AddressDto addressDto) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.addressDto = addressDto;
    }

    public static OngDto fromModel(OngModel model){
        return new OngDto(model.getId(), model.getCnpj(), 
                          model.getName(), model.getEmail(), model.getDdd(), 
                          model.getPhone(), AddressDto.fromModel(model.getAddressModel()));
    }

    public static OngModel toModel(OngDto dto){
        return new OngModel(dto.getCnpj(), dto.getName(), dto.getEmail(),
                            dto.getDdd(), dto.getPhone(), AddressDto.fromDto(dto.getAddressDto()));
    }
}
