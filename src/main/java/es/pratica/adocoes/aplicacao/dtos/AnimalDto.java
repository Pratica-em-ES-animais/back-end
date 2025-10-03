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

    @Max(value = 23)
    @Min(value = 0)
    private int age;

    @Pattern(regexp = "M|F")
    private String sex;

    @Size(max= 255)
    private String description;

    private StatusPetDto status;

    // Relação com Tutor (pode ser null se ainda não tiver)
    private List<String> tutorIds;

    public AnimalDto(String name, String species, String breed, int age, String sex, String description, List<String> tutorIds, StatusPetDto status){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.tutorIds = tutorIds;
        this.status = status;
    }

    // retrieving an animal
    public static AnimalDto fromModel(AnimalModel model){
        return new AnimalDto(
            model.getId(),
            model.getName(),
            model.getSpecies(),
            model.getBreed(),
            model.getAge(),
            model.getSex(),
            model.getDescription(),
            StatusPetDto.valueOf(model.getStatus().name()),
            model.getTutorIds()
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
            dto.getDescription(),
            dto.getTutorIds(),
            StatusPetModel.valueOf(dto.getStatus().name())
        );
    }
}
