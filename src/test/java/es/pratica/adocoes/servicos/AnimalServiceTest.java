package es.pratica.adocoes.servicos;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.AnimalRepoInterface;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.enums.CatBreed;
import es.pratica.adocoes.dominio.enums.DogBreed;
import es.pratica.adocoes.dominio.enums.Energy;
import es.pratica.adocoes.dominio.enums.PetSize;
import es.pratica.adocoes.dominio.enums.Sex;
import es.pratica.adocoes.dominio.enums.Sociability;
import es.pratica.adocoes.dominio.enums.Species;
import es.pratica.adocoes.dominio.enums.StatusPet;
import es.pratica.adocoes.dominio.enums.Temperament;
import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInterface;

@SpringBootTest
@ActiveProfiles("test")
public class AnimalServiceTest {
    
    @Autowired
    private AnimalServiceInterface animalService;
    
    @Autowired
    private AnimalRepoInterface animalRepoInterface;

    @AfterEach
    public void cleanDb(){
        this.animalRepoInterface.deleteAll();
    }

    @Test
    public void shouldAdd(){
        AnimalModel animal = new AnimalModel(
            "Alemao", // name
            Species.Cachorro, // species
            DogBreed.VIRA_LATA,
            null, // breed
            Sex.M, // sex
            7, // age
            PetSize.Medio, // size
            true, // neutered
            true, // vaccinated
            Temperament.Normal, // temperament
            Energy.Baixa, // energy
            Sociability.Sociavel, // sociability
            "photo_base64_data_here", // photo
            "Vaccinated in 2023. Regular checkups done.", // health_details
            "é um cachorro fofo demais", // description
            StatusPet.AVAILABLE, // status
            null // tutorIds
        );

        var response = this.animalService.createAnimal(animal);
        animal.setId(response.getId());
        assertEquals(animal, response);
    }

    @Test
    public void getAllShouldReturnEmpty(){
        assertTrue(this.animalService.getAll().isEmpty());
    }

    @Test
    public void getAllShouldReturnNonEmpty(){
        AnimalModel animal = new AnimalModel(
            "Alemao", // name
            Species.Cachorro, // species
            DogBreed.VIRA_LATA,
            null, // breed
            Sex.M, // sex
            7, // age
            PetSize.Medio, // size
            true, // neutered
            true, // vaccinated
            Temperament.Normal, // temperament
            Energy.Baixa, // energy
            Sociability.Sociavel, // sociability
            "photo_base64_data_here", // photo
            "Vaccinated in 2023. Regular checkups done.", // health_details
            "é um cachorro fofo demais", // description
            StatusPet.AVAILABLE, // status
            null // tutorIds
        );

        this.animalService.createAnimal(animal);
        assertFalse(this.animalService.getAll().isEmpty());
    }

}
