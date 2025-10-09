package es.pratica.adocoes.dominio.interfacerepositorios;

import es.pratica.adocoes.dominio.modelos.AdoptionModel;

public interface  AdoptionRepository {
    public AdoptionModel add(AdoptionModel adoptionModel);
    public void removeAll();
}
