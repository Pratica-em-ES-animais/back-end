package es.pratica.adocoes.dominio.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import es.pratica.adocoes.dominio.interfacerepositorios.TutorRepository;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.TutorServiceInterface;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TutorService implements TutorServiceInterface {
    private final TutorRepository tutorRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public TutorModel createTutor(TutorModel tutorModel) {
        if(tutorRepository.getByEmail(tutorModel.getEmail()).isPresent()){
            return null;
        }
        //encodes password
        tutorModel.setSenha(passwordEncoder.encode(tutorModel.getSenha()));
        return this.tutorRepository.add(tutorModel);
    }

    @Override
    public Optional<TutorModel> getByEmail(String email) {
        return this.getByEmail(email);
    }
    
}
