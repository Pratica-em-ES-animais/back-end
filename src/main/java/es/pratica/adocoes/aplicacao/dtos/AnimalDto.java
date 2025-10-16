package es.pratica.adocoes.aplicacao.dtos;

import java.util.List;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;
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
    @Size(min=1, max=30)
    private String species;

    @Size(min=1, max=50)
    private String breed;

    @Pattern(regexp = "M|F")
    private String sex;

    @Min(value = 0)
    @Max(23)
    private Integer age;

    @Size(min=1, max=20)
    private String size;

    private Boolean neutered;

    private Boolean vaccinated;

    @Size(max=50)
    private String temperament;

    @Size(max=20)
    private String energy;

    @Size(max=20)
    private String sociability;

    private String photo; // Can store Base64 encoded image or file path/URL

    @Size(max= 1000) // Allow larger size for health history
    private String health_details; // Pet's historical health content

    @Size(max= 255)
    private String description;

    private StatusPetDto status;

    // Relação com Tutor (pode ser null se ainda não tiver)
    private List<String> tutorIds;

    public AnimalDto(String name, String species, String breed, Integer age, String sex, String size,
                    Boolean neutered, Boolean vaccinated, String temperament, String energy, String sociability,
                    String photo, String health_details, String description, List<String> tutorIds, StatusPetDto status){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.size = size;
        this.neutered = neutered;
        this.vaccinated = vaccinated;
        this.temperament = temperament;
        this.energy = energy;
        this.sociability = sociability;
        this.photo = photo;
        this.health_details = health_details;
        this.description = description;
        this.tutorIds = tutorIds;
        this.status = status;
    }

    // retrieving an animal
    public static AnimalDto fromModel(AnimalModel model){
        return new AnimalDto(
            model.getName(),
            model.getSpecies(),
            model.getBreed(),
            model.getAge(),
            model.getSex(),
            model.getSize(),
            model.getNeutered(),
            model.getVaccinated(),
            model.getTemperament(),
            model.getEnergy(),
            model.getSociability(),
            model.getPhoto(),
            model.getHealth_details(),
            model.getDescription(),
            model.getTutorIds(),
            StatusPetDto.valueOf(model.getStatus().name())
        );
    }

    // creating an animal
    public static AnimalModel toModel(AnimalDto dto){ 
        return new AnimalModel(
            dto.getName(),
            dto.getSpecies(),
            dto.getBreed(),
            dto.getAge(),
            dto.getSex(),
            dto.getSize(),
            dto.getNeutered(),
            dto.getVaccinated(),
            dto.getTemperament(),
            dto.getEnergy(),
            dto.getSociability(),
            dto.getPhoto(),
            dto.getHealth_details(),
            dto.getDescription(),
            dto.getTutorIds(),
            StatusPetModel.valueOf(dto.getStatus().name())
        );
    }
}
