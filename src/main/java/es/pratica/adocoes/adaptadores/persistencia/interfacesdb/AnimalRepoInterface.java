package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AnimalEntity;

public interface AnimalRepoInterface extends MongoRepository<AnimalEntity, String> {
    public Optional<AnimalEntity> findByName(String name);
}
