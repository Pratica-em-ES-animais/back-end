package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.junit.jupiter.api.Test;
import es.pratica.adocoes.aplicacao.dtos.AnimalDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class AnimalDtoTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();

    @Test
    public void emptyNameShouldNotAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName("");
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void notEmptyNameShouldAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setName("a");
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertTrue(violation.isEmpty());
    }
    
    @Test
    public void invalidSexShouldNotAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setSex("a");
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validSexShouldAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setSex("F");
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void invalidAgeShouldNotAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setAge(-1);
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void invalidAgeGreaterThanShouldNotAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setAge(24);
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertFalse(violation.isEmpty());
    }

    
    @Test
    public void validAgeShouldAllow(){
        AnimalDto animalDto = new AnimalDto();
        animalDto.setAge(23);
        Set<ConstraintViolation<AnimalDto>> violation = this.validator.validate(animalDto);
        assertTrue(violation.isEmpty());
    }

    

}
