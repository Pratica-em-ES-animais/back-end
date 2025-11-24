package es.pratica.adocoes.dominio.interfacerepositorios;

import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.TutorModel;

public interface  TutorRepository {
    public TutorModel add(TutorModel tutorModel);
    public Optional<TutorModel> getByEmail(String email);
    public Optional<TutorModel> getById(String id);

}
