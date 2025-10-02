package es.pratica.adocoes.aplicacao.dtos;

import org.springframework.data.mongodb.core.index.Indexed;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.OngModel;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TutorCreateDto {
    @NonNull
    @Indexed(unique = true)
    private String cpf;
    @NonNull
    @Size(min=1, max=50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String firstName;
    @NonNull
    @Size(min=1, max=50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String lastName;
    @NonNull
    @Email
    private String email;
    @Pattern(regexp = "[0-9]{2}")
    @NonNull
    private String ddd;
    @NonNull
    @Pattern(regexp = "9\\d{8}")
    private String phone;
    private String senha;
    private String ongId;

    public static TutorModel fromDto(TutorCreateDto dto){
        var ongModel = new OngModel();
        ongModel.setId(dto.getOngId());
        return new TutorModel(dto.getCpf(), dto.getFirstName(), dto.getLastName(),dto.getEmail(),dto.getDdd(), dto.getPhone(), dto.getSenha(), ongModel);
    }
}
