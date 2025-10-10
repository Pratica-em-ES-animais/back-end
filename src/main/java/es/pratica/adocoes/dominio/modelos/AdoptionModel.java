package es.pratica.adocoes.dominio.modelos;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdoptionModel {

    private final String id;
    private final String animalId;
    private final String tutorId;
    private final String adopterId;
    private final LocalDateTime requestDateTime;
    private final StatusAdoptionModel status;


    public static AdoptionModel createNewRequest(String animalId, String tutorId, String adopterId) {

        return new AdoptionModel(
            null,
            animalId,
            tutorId,
            adopterId,
            LocalDateTime.now(),
            StatusAdoptionModel.PENDING
        );
    }

    public static AdoptionModel reconstitute(String id, String animalId, String tutorId, String adopterId, LocalDateTime requestDateTime, StatusAdoptionModel status) {
        return new AdoptionModel(id, animalId, tutorId, adopterId, requestDateTime, status);
    }
    
}