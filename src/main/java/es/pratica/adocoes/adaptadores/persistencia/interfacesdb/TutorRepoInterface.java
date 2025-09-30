package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.TutorEntity;

public interface TutorRepoInterface extends MongoRepository<TutorEntity, String>{
    public Optional<TutorEntity> findByEmail(String email);
}
