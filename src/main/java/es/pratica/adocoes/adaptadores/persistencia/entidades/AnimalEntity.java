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
    private String sex;
    private Integer age;
    private String size;
    private Boolean neutered;
    private Boolean vaccinated;
    private String temperament;
    private String energy;
    private String sociability;
    private String photo;
    private String health_details;
    private String description;
    private List<String> tutorIds;
    private StatusPetEntity statusPet;

    

    // Conversão Model -> Entity
    public AnimalEntity(String name, String species, String breed, Integer age, String sex, String size,
            Boolean neutered, Boolean vaccinated, String temperament, String energy, String sociability,
            String photo, String health_details, String description, List<String> tutorIds, StatusPetEntity statusPet) {
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
        this.statusPet = statusPet;
    }

    public static AnimalEntity fromModel(AnimalModel model){
        return new AnimalEntity(
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
            StatusPetEntity.valueOf(model.getStatus().name())
        );
    }

    protected AnimalEntity(){}
}
