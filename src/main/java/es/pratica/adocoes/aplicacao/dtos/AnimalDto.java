package es.pratica.adocoes.aplicacao.dtos;

import java.util.List;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalDto {
    private String id;

    @NonNull
    @NotBlank
    private String name;

    @NonNull
    @Max(30)
    @NotBlank
    private String species;

    @Max(50)
    private String breed;

    private Integer age;

    @Pattern(regexp = "M|F")
    private String sex;

    @Max(255)
    private String description;

    private StatusPetDto status;

    // Relação com Tutor (pode ser null se ainda não tiver)
    private List<String> tutorIds;


    public AnimalDto(){}

    public AnimalDto(String name, String species, String breed, Integer age, String sex, String description, List<String> tutorIds, StatusPetDto status){
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
            dto.getDescription(),
            dto.getTutorIds(),
            StatusPetModel.valueOf(dto.getStatus().name())
        );
    }
}
