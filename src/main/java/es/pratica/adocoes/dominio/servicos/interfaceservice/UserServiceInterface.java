package es.pratica.adocoes.dominio.servicos.interfaceservice;

import es.pratica.adocoes.dominio.modelos.UserModel;

public interface UserServiceInterface {
    public UserModel createUser(UserModel userModel);   
    public void removeAll();
    public UserModel getById(String id);
}
