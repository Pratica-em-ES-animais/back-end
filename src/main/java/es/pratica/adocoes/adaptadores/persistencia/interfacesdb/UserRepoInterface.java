package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.UserEntity;

public interface UserRepoInterface extends MongoRepository<UserEntity, String>{
    public Optional<UserEntity> findByEmail(String email);
}
