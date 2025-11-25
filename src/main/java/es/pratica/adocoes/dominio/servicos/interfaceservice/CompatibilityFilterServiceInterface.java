package es.pratica.adocoes.dominio.servicos.interfaceservice;
import es.pratica.adocoes.aplicacao.dtos.PetCompatibilityDto;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.modelos.AnimalModel;

import java.util.List;

public interface CompatibilityFilterServiceInterface {
    List<PetCompatibilityDto> filter(UserDto user, List<AnimalModel> pets, int topK);
}
