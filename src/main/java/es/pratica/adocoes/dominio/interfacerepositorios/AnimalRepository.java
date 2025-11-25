package es.pratica.adocoes.dominio.interfacerepositorios;

import java.util.List;
import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.AnimalModel;

public interface AnimalRepository {

    AnimalModel add(AnimalModel animalModel);

    Optional<AnimalModel> getById(String id);

    void removeAll();

    void removeById(String id); // ← novo método

    Optional<AnimalModel> getByName(String name);

    List<AnimalModel> getAll();

    AnimalModel update(AnimalModel animalModel);
}

