package es.pratica.adocoes.aplicacao.dtos;


import es.pratica.adocoes.dominio.modelos.AdoptionModel;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionDto {

    @Nonnull
    private String animalId;

    @Nonnull
    private String tutorId;

    @Nonnull
    private String adopterId;


    public static AdoptionDto fromModel(AdoptionModel model) {
        return new AdoptionDto(
            model.getAnimalId(),
            model.getTutorId(),
            model.getAdopterId()
        );
    }

    public AdoptionModel toModel() {
        return AdoptionModel.createNewRequest(
            this.animalId,
            this.tutorId,
            this.adopterId
        );
    }
    
    
}
