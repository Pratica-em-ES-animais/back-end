package es.pratica.adocoes.dominio.interfacerepositorios;

import java.util.List;

import es.pratica.adocoes.dominio.modelos.AnimalModel;
import es.pratica.adocoes.dominio.modelos.StatusPetModel;

public interface AnimalRepository {
    public List<AnimalModel> getAll();
    public AnimalModel add(AnimalModel animalModel);
    public List<AnimalModel> getByStatusPet(StatusPetModel statusPetModel);
}
