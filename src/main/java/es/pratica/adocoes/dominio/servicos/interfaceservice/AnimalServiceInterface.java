package es.pratica.adocoes.dominio.servicos.interfaceservice;

import java.util.List;
import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.AnimalModel;

public interface AnimalServiceInterface {
    public AnimalModel createAnimal(AnimalModel animalModel);   
    public void removeAll();
    Optional<AnimalModel> getById(String id);
    Optional<AnimalModel> getByName(String name);
    public List<AnimalModel> getAll();
}
