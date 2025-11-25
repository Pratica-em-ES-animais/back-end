package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;

import es.pratica.adocoes.dominio.servicos.interfaceservice.AnimalServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeleteAnimalUC {

    private final AnimalServiceInterface animalService;

    /**
     * @return true  -> deletado com sucesso
     *         false -> animal não existe
     */
    public boolean run(String animalId) {

        var animalOpt = animalService.getById(animalId);
        if (animalOpt.isEmpty()) {
            return false;
        }

        animalService.deleteById(animalId);
        return true;
    }
}
