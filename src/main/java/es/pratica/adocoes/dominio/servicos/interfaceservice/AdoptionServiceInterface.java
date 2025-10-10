package es.pratica.adocoes.dominio.servicos.interfaceservice;

import es.pratica.adocoes.dominio.modelos.AdoptionModel;

public interface  AdoptionServiceInterface {
    public AdoptionModel createAdoption(AdoptionModel adoptionModel);
    public void removeAll();
}
