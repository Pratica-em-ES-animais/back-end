package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.enums.Role;

public class UserDetailsDTO extends DetailsBaseDTO {
    private String lifestyle;
    private String preferences;

    public UserDetailsDTO(String id, Role role, String firstName, String lastName, String lifestyle, String preferences) {
        super(id, role, firstName, lastName);
        this.lifestyle = lifestyle;
        this.preferences = preferences;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}

