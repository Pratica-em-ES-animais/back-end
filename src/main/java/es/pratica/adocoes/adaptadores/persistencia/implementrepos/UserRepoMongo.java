package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.UserEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.UserRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.UserRepository;
import es.pratica.adocoes.dominio.modelos.UserModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserRepoMongo implements UserRepository{
    private final UserRepoInterface userRepo;

    @Override
    public UserModel add(UserModel userModel) {
        return UserModel.toModel(this.userRepo.save(UserEntity.fromModel(userModel)));
    }
    

    @Override
    public void removeAll(){
        this.userRepo.deleteAll();
    }


    @Override
    public UserModel getById(String id) {
        return UserModel.toModel(this.userRepo.findById(id).get());
    }
}