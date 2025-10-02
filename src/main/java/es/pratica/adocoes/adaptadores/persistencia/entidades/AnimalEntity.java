package es.pratica.adocoes.adaptadores.persistencia.entidades;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class AnimalEntity {
    @Id
    private String id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String sex;
    private String description;
    private List<String> tutorIds;
    private StatusPetEntity statusPet;

    // Conversão Model -> Entity
    public static AnimalEntity fromModel(AnimalModel model){
        return new AnimalEntity(
            model.getId(),
            model.getName(),
            model.getSpecies(),
            model.getBreed(),
            model.getAge(),
            model.getSex(),
            model.getDescription(),
            model.getTutorIds()
            model.valueOf(model.getStatusPet().name())
        );
    }

    protected AnimalEntity(){}
}
