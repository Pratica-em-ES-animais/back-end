package es.pratica.adocoes.aplicacao.casosdeuso;

import org.springframework.stereotype.Component;
import es.pratica.adocoes.aplicacao.dtos.TutorCreateDto;
import es.pratica.adocoes.aplicacao.dtos.TutorResponseDto;
import es.pratica.adocoes.dominio.servicos.interfaceservice.TutorServiceInterface;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CreateTutorUC {
    private final TutorServiceInterface tutorService;
    
    public TutorResponseDto createTutor(TutorCreateDto dto){
        var response = this.tutorService.createTutor(TutorCreateDto.fromDto(dto));
        if(response == null){
            return null;
        }
        return TutorResponseDto.fromModel(response);
    }
}
