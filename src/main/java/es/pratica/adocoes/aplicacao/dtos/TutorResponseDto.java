package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.enums.Role;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TutorResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private String ddd;
    private String phone;
    private Role role;


    public static TutorResponseDto fromModel(TutorModel model){
        return new TutorResponseDto(model.getId(),model.getFirstName(),model.getLastName(),
        model.getEmail(),model.getCpf(),model.getDdd(),model.getPhone(), model.getRole());        
    }
}
