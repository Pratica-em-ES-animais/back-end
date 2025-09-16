package es.pratica.adocoes.dominio.interfacerepositorios;

import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.TutorModel;

public interface  TutorRepository {
    public TutorModel add(TutorModel userModel);
    public Optional<TutorModel> getByEmail(String email);
}
