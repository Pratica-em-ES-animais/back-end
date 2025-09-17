package es.pratica.adocoes.dominio.servicos.interfaceservice;

import es.pratica.adocoes.dominio.modelos.TutorModel;

public interface  TutorServiceInterface {
    public TutorModel createTutor(TutorModel tutorModel);
    public TutorModel getByEmail(String email);
}
