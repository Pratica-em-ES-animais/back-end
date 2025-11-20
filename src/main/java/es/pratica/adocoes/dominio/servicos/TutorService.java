package es.pratica.adocoes.dominio.servicos;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import es.pratica.adocoes.dominio.interfacerepositorios.OngRepository;
import es.pratica.adocoes.dominio.interfacerepositorios.TutorRepository;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.TutorServiceInterface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TutorService implements TutorServiceInterface {
    private final TutorRepository tutorRepository;
    private final PasswordEncoder passwordEncoder;
    private final OngRepository ongRepository;

    @Override
    public TutorModel createTutor(TutorModel tutorModel) {
        if(tutorRepository.getByEmail(tutorModel.getEmail()).isPresent()){
            return null;
        }
        
        var ong = ongRepository.getById(tutorModel.getOngModel().getId());
        // if ong does not exists return null
        if(ong.isEmpty()){
           return null;
        }
        //sets ong
        tutorModel.setOngModel(ong.get());
        //encodes password
        tutorModel.setSenha(passwordEncoder.encode(tutorModel.getSenha()));
        return this.tutorRepository.add(tutorModel);
    }

    @Override
    public Optional<TutorModel> getByEmail(String email) {
        return this.tutorRepository.getByEmail(email);
    }
    
}
