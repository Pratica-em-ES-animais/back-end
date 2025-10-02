package es.pratica.adocoes.dominio.modelos;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AnimalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class AnimalModel {
    private String id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private String description;
    private String tutorId;

    // Construtor sem id (usado antes de persistir)
    public AnimalModel(String name, String species, String breed, Integer age, String sex, String description, String tutorId){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.tutorId = tutorId;
    }

    // Conversão de Entity -> Model (mesmo padrão do UserModel)
    public static AnimalModel toModel(AnimalEntity ae){
        if (ae == null) return null;
        return new AnimalModel(
            ae.getId(),
            ae.getName(),
            ae.getSpecies(),
            ae.getBreed(),
            ae.getAge(),
            ae.getSex(),
            ae.getDescription(),
            ae.getTutorId()
        );
    }
}
