package es.pratica.adocoes.dominio.servicos;

import java.util.Optional;

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
    public Optional<UserModel> getById(String id) {
        return this.userRepositorio.getById(id);
    }

    @Override
    public Optional<UserModel> getByEmail(String email) {
        return this.userRepositorio.getByEmail(email);
    }

   
}
