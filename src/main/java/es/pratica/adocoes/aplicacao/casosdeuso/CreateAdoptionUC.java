package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.dominio.interfacerepositorios.AdoptionRepository;
import es.pratica.adocoes.dominio.interfacerepositorios.AnimalRepository;
import es.pratica.adocoes.dominio.interfacerepositorios.TutorRepository;
import es.pratica.adocoes.dominio.interfacerepositorios.UserRepository;
import es.pratica.adocoes.dominio.modelos.AdoptionModel;
import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.enums.StatusPet;


@Component
public class CreateAdoptionUC { 
    private final AdoptionRepository adoptionRepository;
    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final TutorRepository tutorRepository;

    public CreateAdoptionUC(AdoptionRepository adoptionRepository, AnimalRepository animalRepository, UserRepository userRepository, TutorRepository tutorRepository) {
        this.adoptionRepository = adoptionRepository;
        this.animalRepository = animalRepository;
        this.userRepository = userRepository;
        this.tutorRepository = tutorRepository;
    }

    public AdoptionModel run(String animalId, String adopterId, String tutorId) {
        AnimalModel animal = animalRepository.getById(animalId)
                .orElseThrow(() -> new IllegalArgumentException("Animal com ID " + animalId + " não encontrado."));
     
        if (!userRepository.getById(adopterId).isPresent()) {
            throw new IllegalArgumentException("Adotante com ID " + adopterId + " não encontrado.");
        }
        if (!tutorRepository.getById(tutorId).isPresent()) {
            throw new IllegalArgumentException("Tutor com ID " + tutorId + " não encontrado.");
        }
        if (!animal.getStatus().equals(StatusPet.AVAILABLE)) {
            throw new IllegalStateException("Este animal não está disponível para adoção no momento.");
        }
    
        AdoptionModel newAdoptionRequest = AdoptionModel.createNewRequest(
            animalId,
            tutorId,
            adopterId
        );

        animal.setStatus(StatusPet.PENDING);
        animalRepository.add(animal); 

        return adoptionRepository.add(newAdoptionRequest);
    }
}