package es.pratica.adocoes.dominio.servicos;

import es.pratica.adocoes.dominio.interfacerepositorios.UserRepositorio;
import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserService {
    private final UserRepositorio userRepositorio;
    
    public UserModel createUser(UserModel userModel){
        return this.userRepositorio.add(userModel);
    }
}
