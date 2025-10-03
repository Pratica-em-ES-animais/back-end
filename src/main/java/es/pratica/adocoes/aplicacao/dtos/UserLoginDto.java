package es.pratica.adocoes.aplicacao.dtos;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDto {
    @Nonnull
    @Email
    private String email;
    @Nonnull
    private String senha;


}
