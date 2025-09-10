package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;


import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.UserEntity;

public interface UserRepoInterface extends MongoRepository<UserEntity, String>{
}
