package es.pratica.adocoes.dominio.servicos.interfaceservice;
import es.pratica.adocoes.aplicacao.dtos.UserDto;
import es.pratica.adocoes.dominio.modelos.AnimalModel;

import java.util.List;
import java.util.Map;

public interface CompatibilityFilterServiceInterface {
    List<Map<String, Object>> filter(UserDto userProfile, List<AnimalModel> pets, int topN);
}