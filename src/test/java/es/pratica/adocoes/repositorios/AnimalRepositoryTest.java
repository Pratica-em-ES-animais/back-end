package es.pratica.adocoes.repositorios;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.adaptadores.persistencia.entidades.StatusPetEntity;
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
    private AnimalRepoInterface animalRepoInterface;

    @AfterEach
    public void cleanDb(){
        this.animalRepoInterface.deleteAll();
    }

    @Test
    public void addingAnimalShouldChangeDbState(){
        AnimalModel animal = new AnimalModel(StatusPetModel.DISPONIVEL, "Alemao", 7, "é um cachorro muito fofo.",false, false, false, false, true, false);
        this.animalRepository.add(animal);
        assertNotEquals(0,this.animalRepository.getAll().size());
    }

    @Test
    public void notAddingAndGettingAllShouldReturnEmpty(){
        assertTrue(this.animalRepository.getAll().isEmpty());
    }
    
    @Test
    public void addingAndGettingAllShouldReturnNonEmpty(){
        AnimalModel animal = new AnimalModel(StatusPetModel.DISPONIVEL, "Alemao", 7, "é um cachorro muito fofo.",false, false, false, false, true, false);
        this.animalRepository.add(animal);
        assertFalse(this.animalRepository.getAll().isEmpty());
    }

    @Test
    public void notAddindAndGettingByStatusShouldReturnEmpty(){
        assertTrue(this.animalRepository.getByStatusPet(StatusPetModel.ADOTADO).isEmpty());
    }

    @Test
    public void addindAndGettingByStatusShouldReturnNotEmpty(){
        AnimalModel animal = new AnimalModel(StatusPetModel.DISPONIVEL, "Alemao", 7, "é um cachorro muito fofo.",false, false, false, false, true, false);
        this.animalRepository.add(animal);
        assertFalse(this.animalRepository.getByStatusPet(StatusPetModel.DISPONIVEL).isEmpty());
    }
}
