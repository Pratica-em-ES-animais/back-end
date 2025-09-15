package es.pratica.adocoes.dominio.interfacerepositorios;
import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.UserModel;


public interface UserRepository {
    public UserModel add(UserModel userModel);
    public Optional<UserModel> getById(String id);
    public void removeAll();
    public Optional<UserModel> getByEmail(String email);
}
