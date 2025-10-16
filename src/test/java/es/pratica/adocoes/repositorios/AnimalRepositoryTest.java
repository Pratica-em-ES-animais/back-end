package es.pratica.adocoes.repositorios;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.AnimalRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;

@ActiveProfiles("test")
@SpringBootTest
public class AnimalRepositoryTest {
    
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AnimalRepoInterface animalRepoMongo;

    
    @AfterEach
    public void cleanDb(){
        this.animalRepoMongo.deleteAll();
    }

    @Test
    public void addingAnimalShouldChangeDbState(){
        AnimalModel animal = new AnimalModel("Alemao", "Dog", "Mixed", 7, "M", "Medium", true, true, "Calm", "Low", "Sociable", "photo_base64_data_here", "Vaccinated in 2023. Regular checkups done.", "é um cachorro fofo demais", null, StatusPetModel.AVAILABLE);
        this.animalRepository.add(animal);
        assertNotEquals(0,animalRepoMongo.count());
    }

    @Test
    public void gettingAllShouldReturnNonEmptyList(){
        AnimalModel animal = new AnimalModel("Alemao", "Dog", "Mixed", 7, "M", "Medium", true, true, "Calm", "Low", "Sociable", "photo_base64_data_here", "Vaccinated in 2023. Regular checkups done.", "é um cachorro fofo demais", null, StatusPetModel.AVAILABLE);
        this.animalRepository.add(animal);
        assertFalse(this.animalRepository.getAll().isEmpty());
    }
    
    @Test
    public void gettingAllShouldReturnEmptyList(){
        assertTrue(this.animalRepository.getAll().isEmpty());
    }

    @Test
    public void gettingByNameShouldReturnAnimal(){
        AnimalModel animal = new AnimalModel("Alemao", "Dog", "Mixed", 7, "M", "Medium", true, true, "Calm", "Low", "Sociable", "photo_base64_data_here", "Vaccinated in 2023. Regular checkups done.", "é um cachorro fofo demais", null, StatusPetModel.AVAILABLE);
        this.animalRepository.add(animal);
        assertNotNull(this.animalRepository.getByName("Alemao"));
    }

}
