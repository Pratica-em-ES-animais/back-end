package es.pratica.adocoes.adaptadores.persistencia.implementrepos;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.pratica.adocoes.adaptadores.persistencia.entidades.TutorEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.TutorRepoInterface;
import es.pratica.adocoes.dominio.enums.Role;
import es.pratica.adocoes.dominio.interfacerepositorios.TutorRepository;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TutorRepoMongo implements TutorRepository{
    
    private final TutorRepoInterface tutorRepo;

    @Override
    public TutorModel add(TutorModel tutorModel) {
        tutorModel.setRole(Role.ONG);
        this.tutorRepo.save(TutorEntity.fromModel(tutorModel));
        return tutorModel;
    }

    @Override
    public Optional<TutorModel> getByEmail(String email){
        var response = this.tutorRepo.findByEmail(email);
        if(response.isPresent()){
            return response.map(TutorModel::toModel);
        }
        return Optional.empty();
    }

    public Optional<TutorModel> getById(String id){
        var response = tutorRepo.findById(id);
        if(response.isPresent()){
            return response.map(TutorModel::toModel);
        }
        return Optional.empty();
    }


    
}
