package es.pratica.adocoes.adaptadores.persistencia.entidades;

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

    @NonNull
    @Max(50)
    @NotBlank
    private String name;

    @NonNull
    @Max(30)
    @NotBlank
    private String species;

    @Max(50)
    private String breed;

    private Integer age;

    @Pattern(regexp = "M|F|Outro")
    private String sex;

    @Max(255)
    private String description;

    // Relação com Tutor (pode ser null se ainda não tiver)
    private String tutorId;

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
            model.getTutorId()
        );
    }

    protected AnimalEntity(){}
}
