package es.pratica.adocoes.dominio.servicos.interfaceservice;

import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.UserModel;

public interface UserServiceInterface {
    public UserModel createUser(UserModel userModel);   
    public void removeAll();
    Optional<UserModel> getById(String id);
    Optional<UserModel> getByEmail(String email);
}
