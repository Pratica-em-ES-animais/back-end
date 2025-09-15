package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import java.util.Optional;

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
    public Optional<UserModel> getById(String id) {
        var response = this.userRepo.findById(id);
        return response.map(ue -> UserModel.toModel(ue));
    }

    @Override
    public Optional<UserModel> getByEmail(String email) {
        var response = this.userRepo.findByEmail(email);
        System.out.println("Aqui!");
        return response.map(ue -> UserModel.toModel(ue));
    }
}