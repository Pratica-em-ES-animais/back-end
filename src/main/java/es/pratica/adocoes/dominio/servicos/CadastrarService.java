package es.pratica.adocoes.dominio.servicos;

import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.interfacerepositorios.UserRepositorio;
import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CadastrarService {
    private final UserRepositorio userRepositorio;
    
    public UserModel createUser(UserModel userModel){
        return this.userRepositorio.add(userModel);
    }
}
