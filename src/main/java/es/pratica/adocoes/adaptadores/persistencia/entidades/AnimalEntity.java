package es.pratica.adocoes.adaptadores.persistencia.entidades;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class AnimalEntity {
    @Id
    private String id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private String description;
    private List<String> tutorIds;
    private StatusPetEntity statusPet;

    

    // Conversão Model -> Entity
    public AnimalEntity(String name, String species, String breed, Integer age, String sex, String description,
            List<String> tutorIds, StatusPetEntity statusPet) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.tutorIds = tutorIds;
        this.statusPet = statusPet;
    }

    public static AnimalEntity fromModel(AnimalModel model){
        return new AnimalEntity(
            model.getId(),
            model.getName(),
            model.getSpecies(),
            model.getBreed(),
            model.getAge(),
            model.getSex(),
            model.getDescription(),
            model.getTutorIds(),
            StatusPetEntity.valueOf(model.getStatus().name())
        );
    }

    protected AnimalEntity(){}
}
