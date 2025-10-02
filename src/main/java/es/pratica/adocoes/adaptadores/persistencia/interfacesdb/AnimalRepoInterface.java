package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AnimalEntity;
import es.pratica.adocoes.adaptadores.persistencia.entidades.StatusPetEntity;

public interface AnimalRepoInterface extends MongoRepository<AnimalEntity, String> {
    public List<AnimalEntity> findByStatusPet(StatusPetEntity statusPetEntity);
}
