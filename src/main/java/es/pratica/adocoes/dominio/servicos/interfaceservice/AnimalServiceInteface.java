package es.pratica.adocoes.dominio.servicos.interfaceservice;

import java.util.List;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;

public interface AnimalServiceInteface {
    public List<AnimalModel> getAll();
    public AnimalModel add(AnimalModel animalModel);
    public List<AnimalModel> getByStatusPet(StatusPetModel statusPetModel);
}
