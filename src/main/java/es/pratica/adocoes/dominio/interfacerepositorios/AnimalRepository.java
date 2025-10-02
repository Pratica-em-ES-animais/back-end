package es.pratica.adocoes.dominio.interfacerepositorios;

import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.AnimalModel;

public interface AnimalRepository {
    public AnimalModel add(AnimalModel animalModel);
    public Optional<AnimalModel> getById(String id);
    public void removeAll();
    public Optional<AnimalModel> getByName(String name);
}
