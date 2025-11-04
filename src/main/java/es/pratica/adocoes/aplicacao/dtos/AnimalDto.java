package es.pratica.adocoes.aplicacao.dtos;

import java.util.List;

import es.pratica.adocoes.dominio.enums.Species;
import es.pratica.adocoes.dominio.enums.Breed;
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
public class AnimalDto {
    private String id;

    @Nonnull
    @Pattern(regexp = "[a-zA-ZÀ-ÿ\\- ]+")
    @Size(min=1, max=60)
    private String name;

    @Nonnull
    private Species species;

    @Nonnull
    private Breed breed;

    @Nonnull
    private Sex sex;

    @Max(value = 50)
    @Min(value = 0)
    @Max(23)
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

    public AnimalDto(String name, Species species, Breed breed, Sex sex, Integer age, PetSize size,
                     Boolean neutered, Boolean vaccinated, Temperament temperament, Energy energy, Sociability sociability,
                     String photo, String health_details, String description, StatusPet status, List<String> tutorIds){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.size = size;
        this.neutered = neutered;
        this.vaccinated = vaccinated;
        this.temperament = temperament;
        this.energy = energy;
        this.sociability = sociability;
        this.photo = photo;
        this.health_details = health_details;
        this.description = description;
        this.status = status;
        this.tutorIds = tutorIds;
    }

    public static AnimalDto fromModel(AnimalModel model){
        return new AnimalDto(
            model.getId(),
            model.getName(),
            model.getSpecies(),
            model.getBreed(),
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

    public static AnimalModel toModel(AnimalDto dto){
        return new AnimalModel(
            dto.getName(),
            dto.getSpecies(),
            dto.getBreed(),
            dto.getSex(),
            dto.getAge(),
            dto.getSize(),
            dto.getNeutered(),
            dto.getVaccinated(),
            dto.getTemperament(),
            dto.getEnergy(),
            dto.getSociability(),
            dto.getPhoto(),
            dto.getHealth_details(),
            dto.getDescription(),
            dto.getStatus(),
            dto.getTutorIds()
        );
    }
}
