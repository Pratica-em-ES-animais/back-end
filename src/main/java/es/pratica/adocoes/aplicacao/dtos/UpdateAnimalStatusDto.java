package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.enums.StatusPet;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateAnimalStatusDto {
    @NotBlank
    private String animalId;
    @NotBlank
    private StatusPet status; // AVAILABLE, ADOPTED, PENDING, LOST, DECEASED
}
