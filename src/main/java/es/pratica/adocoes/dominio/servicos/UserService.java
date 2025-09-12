package es.pratica.adocoes.dominio.servicos;

import org.springframework.stereotype.Service;

import es.pratica.adocoes.dominio.interfacerepositorios.UserRepository;
import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.UserServiceInterface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface{
    private final UserRepository userRepositorio;
    
    @Override
    public UserModel createUser(UserModel userModel){
        return this.userRepositorio.add(userModel);
    }

    @Override
    public void removeAll(){
        this.userRepositorio.removeAll();
    }

    @Override
    public UserModel getById(String id) {
        return this.userRepositorio.getById(id);
    }


   
}
