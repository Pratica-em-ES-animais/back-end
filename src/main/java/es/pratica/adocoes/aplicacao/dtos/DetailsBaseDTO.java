package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DetailsBaseDTO {
    private String id;
    private Role role;
    private String firstName;
    private String lastName;

    
} 