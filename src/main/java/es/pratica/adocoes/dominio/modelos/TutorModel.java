package es.pratica.adocoes.dominio.modelos;


import es.pratica.adocoes.adaptadores.persistencia.entidades.TutorEntity;
import es.pratica.adocoes.dominio.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TutorModel {
    private String id;
    private String cpf;
    private String firstName;
    private String lastName;
    private String email;
    private String ddd;
    private String phone;
    private String senha;
    private OngModel ongModel;
    private Role role;

    public TutorModel(String cpf, String firstName, String lastName, String email,
                      String ddd, String phone, String senha, OngModel ongModel){
        this.cpf = cpf;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.senha = senha;
        this.ongModel = ongModel;
    }

    public static TutorModel toModel(TutorEntity entity) {
        return new TutorModel(entity.getId(), entity.getCpf(), entity.getFirstName(), entity.getLastName(),
                    entity.getEmail(), entity.getDdd(), entity.getPhone(), entity.getSenha(), OngModel.toModel(entity.getOngEntity()), entity.getRole());
    }


    
}
