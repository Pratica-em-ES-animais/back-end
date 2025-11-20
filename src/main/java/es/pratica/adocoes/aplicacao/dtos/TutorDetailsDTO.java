package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.enums.Role;

public class TutorDetailsDTO extends DetailsBaseDTO  {
    public TutorDetailsDTO(String id, Role role, String firstName, String lastName){
        super(id, role, firstName, lastName);
    }
}
