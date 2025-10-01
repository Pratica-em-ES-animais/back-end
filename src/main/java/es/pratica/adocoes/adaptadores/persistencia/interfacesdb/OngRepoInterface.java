package es.pratica.adocoes.adaptadores.persistencia.interfacesdb;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.OngEntity;

public interface OngRepoInterface extends MongoRepository<OngEntity, String>{
    public Optional<OngEntity> findByCnpj(String cnpj);
}
