package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.UserEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.UserRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.UserRepositorio;
import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserRepoMongo implements UserRepositorio{
    private final UserRepoInterface userRepo;

    @Override
    public UserModel add(UserModel userModel) {
        System.out.println(userModel.toString());
        return UserModel.toModel(this.userRepo.save(UserEntity.fromModel(userModel)));
    }
    
}