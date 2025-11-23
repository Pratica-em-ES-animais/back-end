package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.modelos.OngModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OngResponseDto {
    private String id;
    private String name;

    public static OngResponseDto fromModel(OngModel model){
        return new OngResponseDto(model.getId(), model.getName());
    }
}
