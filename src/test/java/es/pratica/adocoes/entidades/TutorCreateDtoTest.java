package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;
import es.pratica.adocoes.aplicacao.dtos.TutorCreateDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class TutorCreateDtoTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();

    @Test
    public void emptyCpfShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setCpf("");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void cpfWithLessThanElevenDigitsShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setCpf("123123");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void cpfWithMoreThanElevenDigitsShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setCpf("123456789123");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void cpfWithLettersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setCpf("1b3456789123");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validCpfShouldAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setCpf("12345678910");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void firstNameWithNumbersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setFirstName("12345678910");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void emptyFirstNameShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setFirstName("");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void firstNameWithMoreThanFiftyOneLettersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        String name = new StringBuilder().repeat("a", 51).toString();
        tutorDto.setFirstName(name);
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validFirstNameShouldAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setFirstName("Joao");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertTrue(violation.isEmpty());
    }

      @Test
    public void lastNameWithNumbersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setLastName("12345678910");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void emptyLastNameShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setLastName("");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void lastNameWithMoreThanFiftyOneLettersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        String name = new StringBuilder().repeat("a", 51).toString();
        tutorDto.setLastName(name);
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validLastNameShouldAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setLastName("Joao");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertTrue(violation.isEmpty());
    }

     @Test
    public void invalidEmailShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setEmail("Joao");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validEmailShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setEmail("joao@gmail.com");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertTrue(violation.isEmpty());
    }

     @Test
    public void dddWithLettersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setDdd("SA");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithMoreThanTwoDigitsShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setDdd("222");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithTwoDigitsShouldAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setDdd("22");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void phoneWithLettersShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setPhone("abs");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithLessThanNineDigitsShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setPhone("123124");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithMoreThanNineDigitsShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setPhone("1234567890");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneNotStartingWithNineShouldNotAllow(){
        TutorCreateDto tutorDto = new TutorCreateDto();
        tutorDto.setPhone("123456789");
        Set<ConstraintViolation<TutorCreateDto>> violation = this.validator.validate(tutorDto);
        assertFalse(violation.isEmpty());
    }
}
