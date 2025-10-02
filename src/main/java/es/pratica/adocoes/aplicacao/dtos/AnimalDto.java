package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalDto {
    private String id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private String description;
    private String tutorId;

    public AnimalDto(){}

    public AnimalDto(String name, String species, String breed, Integer age, String sex, String description, String tutorId) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.tutorId = tutorId;
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
            model.getTutorId()
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
            dto.getTutorId()
        );
    }
}
