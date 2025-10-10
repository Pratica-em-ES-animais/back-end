package es.pratica.adocoes.adaptadores.persistencia.entidades;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.pratica.adocoes.dominio.modelos.AdoptionModel;
import es.pratica.adocoes.dominio.modelos.StatusAdoptionModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class AdoptionEntity {
    @Id
    private String id;
    private String animalId;
    private String tutorId;
    private String adopterId;
    private LocalDateTime requestDateTime;
    private StatusAdoptionModel status;

    public AdoptionEntity(String animalId, String tutorId, String adopterId, LocalDateTime requestDateTime, StatusAdoptionModel status) {
        this.animalId = animalId;
        this.tutorId = tutorId;
        this.adopterId = adopterId;
        this.requestDateTime = requestDateTime;
        this.status = status;
    }

    public static AdoptionEntity fromModel(AdoptionModel model){
        return new AdoptionEntity(
            model.getId(),
            model.getAnimalId(),
            model.getTutorId(),
            model.getAdopterId(),
            model.getRequestDateTime(),
            model.getStatus()
        );
    }

    protected AdoptionEntity(){}

}
