package es.pratica.adocoes.aplicacao.dtos;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.enums.Role;
import es.pratica.adocoes.dominio.modelos.UserModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String id;
    @NonNull
    @Pattern(regexp = "[0-9]{11}")
    private String cpf;
    @NonNull
    @Size(min = 1 , max = 50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String firstName;
    @NonNull
    @Size(min = 1 , max = 50)
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    private String lastName;
    @NonNull
    @Email
    private String email; 
    @Pattern(regexp = "[0-9]{2}")
    @NonNull
    private String ddd;
    @NonNull
    @Pattern(regexp = "[0-9]{9}")
    private String phone;
    private String senha;
    private String lifestyle;
    private String preferences;
    private Role role;

    public UserDto(){}

    public UserDto(String cpf,String firstName, String lastName, String email, String ddd, String phone, String senha) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.senha = senha;
    }

    public UserDto(String cpf,String firstName, String lastName, String email, String ddd, String phone, String senha, String lifestyle, String preferences) {
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.senha = senha;
        this.lifestyle = lifestyle;
        this.preferences = preferences;
    }

    // retrieving an user
    public static UserDto fromModel(UserModel model){
        return new UserDto(model.getId(), model.getCpf(), model.getFirstName(), model.getLastName(), model.getEmail(), model.getDdd(), model.getPhone(), model.getSenha(), model.getLifestyle(), model.getPreferences(), model.getRole());
    }

    // creating an user
    public static UserModel toModel(UserDto dto){ 
        return new UserModel(dto.getCpf(), dto.getFirstName(),dto.getLastName(), dto.getEmail(), dto.getDdd(), dto.getPhone(), dto.getSenha(), dto.getLifestyle(), dto.getPreferences());
    }

}
