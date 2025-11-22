package es.pratica.adocoes.aplicacao.dtos;

import java.util.List;

import es.pratica.adocoes.dominio.enums.Species;
import es.pratica.adocoes.dominio.enums.CatBreed;
import es.pratica.adocoes.dominio.enums.DogBreed;
import es.pratica.adocoes.dominio.enums.Sex;
import es.pratica.adocoes.dominio.enums.PetSize;
import es.pratica.adocoes.dominio.enums.Temperament;
import es.pratica.adocoes.dominio.enums.Energy;
import es.pratica.adocoes.dominio.enums.Sociability;
import es.pratica.adocoes.dominio.enums.StatusPet;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalResponseDto {
    private String id;

    @Nonnull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    @Size(min=1, max=60)
    private String name;

    @Nonnull
    private Species species;

    private DogBreed dogBreed;

    private CatBreed catBreed;

    @Nonnull
    private Sex sex;

    @Max(value = 50)
    @Min(value = 0)
    private Integer age;

    @Nonnull
    private PetSize size;

    @Nonnull
    private Boolean neutered;

    @Nonnull
    private Boolean vaccinated;

    private Temperament temperament;

    private Energy energy;

    private Sociability sociability;

    private String photo;

    @Size(max=1000)
    private String health_details;

    @Size(max=255)
    private String description;

    private StatusPet status;

    private List<String> tutorIds;

    public static AnimalResponseDto fromModel(AnimalModel model){
        return new AnimalResponseDto(
            model.getId(),
            model.getName(),
            model.getSpecies(),
            model.getDogBreed(),
            model.getCatBreed(),
            model.getSex(),
            model.getAge(),
            model.getSize(),
            model.getNeutered(),
            model.getVaccinated(),
            model.getTemperament(),
            model.getEnergy(),
            model.getSociability(),
            model.getPhoto(),
            model.getHealth_details(),
            model.getDescription(),
            model.getStatus(),
            model.getTutorIds()
        );
    }
}
