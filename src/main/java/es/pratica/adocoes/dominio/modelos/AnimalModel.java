package es.pratica.adocoes.dominio.modelos;

import java.util.List;

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
    private StatusPetModel status;

    // Construtor sem id (usado antes de persistir)
    public AnimalModel(String name, String species, String breed, Integer age, String sex, String size, 
                      Boolean neutered, Boolean vaccinated, String temperament, String energy, 
                      String sociability, String photo, String health_details, String description, List<String> tutorIds, StatusPetModel status) {
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

    // Conversão de Entity -> Model (mesmo padrão do UserModel)
    public static AnimalModel toModel(AnimalEntity ae){
        if (ae == null) return null;
        return new AnimalModel(
            ae.getName(),
            ae.getSpecies(),
            ae.getBreed(),
            ae.getAge(),
            ae.getSex(),
            ae.getSize(),
            ae.getNeutered(),
            ae.getVaccinated(),
            ae.getTemperament(),
            ae.getEnergy(),
            ae.getSociability(),
            ae.getPhoto(),
            ae.getHealth_details(),
            ae.getDescription(),
            ae.getTutorIds(),
            StatusPetModel.valueOf(ae.getStatusPet().name())
        );
    }
}
