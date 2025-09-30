package es.pratica.adocoes.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressModel{
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String logradouro;
}
