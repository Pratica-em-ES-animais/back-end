package es.pratica.adocoes.dominio.modelos;

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
    private Species species;
    private DogBreed dogBreed;
    private CatBreed catBreed;
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
    private StatusPet status;
    private List<String> tutorIds;

    // Construtor sem id (usado antes de persistir)
    public AnimalModel(String name, Species species, DogBreed dogBreed, CatBreed catBreed, Sex sex, Integer age, PetSize size, 
                       Boolean neutered, Boolean vaccinated, Temperament temperament, Energy energy, 
                       Sociability sociability, String photo, String health_details, String description, StatusPet status, List<String> tutorIds) {
        this.name = name;
        this.species = species;
        this.dogBreed = dogBreed;
        this.catBreed = catBreed;
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

    // Conversão Model -> Entity
    public static AnimalModel toModel(AnimalEntity ae) {
        return new AnimalModel(
            ae.getId(),
            ae.getName(),
            ae.getSpecies(),
            ae.getDogBreed(),
            ae.getCatBreed(),
            ae.getSex(),
            ae.getAge(),
            ae.getSize(),
            ae.getNeutered(),
            ae.getVaccinated(),
            ae.getTemperament(),
            ae.getEnergy(),
            ae.getSociability(),
            ae.getPhoto(),
            ae.getHealth_details(),
            ae.getDescription(),
            ae.getStatusPet(),
            ae.getTutorIds()
        );
    }
}
