package es.pratica.adocoes.dominio.servicos.interfaceservice;

import es.pratica.adocoes.dominio.modelos.OngModel;

public interface OngServiceInterface {
    public OngModel createOng(OngModel ong);
    public OngModel getByCnpj(String cnpj);
}
