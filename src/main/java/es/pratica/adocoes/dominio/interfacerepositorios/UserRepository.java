package es.pratica.adocoes.dominio.interfacerepositorios;
import es.pratica.adocoes.dominio.modelos.UserModel;


public interface UserRepository {
    public UserModel add(UserModel userModel);
    public UserModel getById(String id);
    public void removeAll();
}
