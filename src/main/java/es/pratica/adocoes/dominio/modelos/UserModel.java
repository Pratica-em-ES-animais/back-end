package es.pratica.adocoes.dominio.modelos;

import lombok.Data;

@Data
public class UserModel {
    private String id;
    private String cnpj;
    private String cpf;
    private boolean isOng;
    
    // representa a criacao de um usuario ONG
    public UserModel(String id, String cnpj){
        this.id = id;
        this.cnpj = cnpj;
    }

    // representa a criacao de um usuario pessoa fisica (adotante)
    public UserModel(String id, String cpf, boolean isOng){
        this.id = id;
        this.cpf = cpf;
        this.isOng = isOng;
    }

    public UserModel(String cnpj, boolean isOng){
        this.cnpj = cnpj;
        this.isOng = isOng;
    }


}

