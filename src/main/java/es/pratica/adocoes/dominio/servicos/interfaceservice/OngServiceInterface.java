package es.pratica.adocoes.dominio.servicos.interfaceservice;

import java.util.List;

import es.pratica.adocoes.dominio.modelos.OngModel;

public interface OngServiceInterface {
    public OngModel createOng(OngModel ong);
    public OngModel getByCnpj(String cnpj);
    public List<OngModel> getAll();
}
