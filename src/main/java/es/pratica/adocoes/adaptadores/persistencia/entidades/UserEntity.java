package es.pratica.adocoes.adaptadores.persistencia.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.Data;

@Document
@Data
public class UserEntity {
    @Id
    private String id;
    @Nullable
    private String cnpj;
    @Nullable
    private String cpf;
    private boolean isOng;


}
