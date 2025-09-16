package es.pratica.adocoes.dominio.modelos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressModel{
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String logradouro;
}
