package es.pratica.adocoes.dominio.servicos.interfaceservice;

import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.TutorModel;

public interface  TutorServiceInterface {
    public TutorModel createTutor(TutorModel tutorModel);
    public Optional<TutorModel> getByEmail(String email);
}
