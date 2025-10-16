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
import es.pratica.adocoes.dominio.modelos.StatusPetModel;
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
        AnimalModel animal = new AnimalModel("Alemão", "Dog", "Mixed", 7, "M", "Medium", true, true, "Calm", "Low", "Sociable", "photo_base64_data_here", "Vaccinated in 2023. Regular checkups done.", "é um cachorro fofo demais", null, StatusPetModel.AVAILABLE);
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
        AnimalModel animal = new AnimalModel("Alemão", "Dog", "Mixed", 7, "M", "Medium", true, true, "Calm", "Low", "Sociable", "photo_base64_data_here", "Vaccinated in 2023. Regular checkups done.", "é um cachorro fofo demais", null, StatusPetModel.AVAILABLE);
        this.animalService.createAnimal(animal);
        assertFalse(this.animalService.getAll().isEmpty());
    }

}
