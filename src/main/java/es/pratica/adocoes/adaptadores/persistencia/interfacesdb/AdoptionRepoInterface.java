package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AdoptionEntity;

public interface AdoptionRepoInterface extends MongoRepository<AdoptionEntity, String> {
    
}
