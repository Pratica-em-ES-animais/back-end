package es.pratica.adocoes.adaptadores.persistencia.entidades;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.pratica.adocoes.dominio.enums.Species;
import es.pratica.adocoes.dominio.enums.Breed;
import es.pratica.adocoes.dominio.enums.Sex;
import es.pratica.adocoes.dominio.enums.PetSize;
import es.pratica.adocoes.dominio.enums.Temperament;
import es.pratica.adocoes.dominio.enums.Energy;
import es.pratica.adocoes.dominio.enums.Sociability;
import es.pratica.adocoes.dominio.enums.StatusPet;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalEntity {
    @Id
    private String id;
    private String name;
    private Species species;
    private Breed breed;
    private Sex sex;
    private Integer age;
    private PetSize size;
    private Boolean neutered;
    private Boolean vaccinated;
    private Temperament temperament;
    private Energy energy;
    private Sociability sociability;
    private String photo;
    private String health_details;
    private String description;
    private StatusPet statusPet;
    private List<String> tutorIds;

    public AnimalEntity(String name, Species species, Breed breed, Sex sex, Integer age, PetSize size,
                        Boolean neutered, Boolean vaccinated, Temperament temperament, Energy energy,
                        Sociability sociability, String photo, String health_details, String description,
                        StatusPet statusPet, List<String> tutorIds) {
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
        this.statusPet = statusPet;
        this.tutorIds = tutorIds;
    }

    // Conversão Model -> Entity
    public static AnimalEntity fromModel(AnimalModel model){
        return new AnimalEntity(
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
}
