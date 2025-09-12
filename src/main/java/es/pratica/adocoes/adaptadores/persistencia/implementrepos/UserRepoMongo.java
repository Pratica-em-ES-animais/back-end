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
        var response = this.userRepo.save(UserEntity.fromModel(userModel));
        return UserModel.toModel(response);
    }
    

    @Override
    public void removeAll(){
        this.userRepo.deleteAll();
    }


    @Override
    public UserModel getById(String id) {
        var response = this.userRepo.findById(id).orElse(null);
        return (response == null) ? null : UserModel.toModel(response);
    }
}