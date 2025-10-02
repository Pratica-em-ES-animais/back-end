package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;
import es.pratica.adocoes.adaptadores.persistencia.entidades.TutorEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class TutorEntityTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();

    @Test
    public void emptyCpfShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setCpf("");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void cpfWithLessThanElevenDigitsShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setCpf("123123");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void cpfWithMoreThanElevenDigitsShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setCpf("123456789123");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void cpfWithLettersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setCpf("1b3456789123");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validCpfShouldAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setCpf("12345678910");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void firstNameWithNumbersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setFirstName("12345678910");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void emptyFirstNameShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setFirstName("");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void firstNameWithMoreThanFiftyOneLettersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        String name = new StringBuilder().repeat("a", 51).toString();
        tutorEntity.setFirstName(name);
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validFirstNameShouldAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setFirstName("Joao");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertTrue(violation.isEmpty());
    }

      @Test
    public void lastNameWithNumbersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setLastName("12345678910");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void emptyLastNameShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setLastName("");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void lastNameWithMoreThanFiftyOneLettersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        String name = new StringBuilder().repeat("a", 51).toString();
        tutorEntity.setLastName(name);
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validLastNameShouldAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setLastName("Joao");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertTrue(violation.isEmpty());
    }

     @Test
    public void invalidEmailShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setEmail("Joao");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validEmailShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setEmail("joao@gmail.com");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertTrue(violation.isEmpty());
    }

     @Test
    public void dddWithLettersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setDdd("SA");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithMoreThanTwoDigitsShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setDdd("222");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithTwoDigitsShouldAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setDdd("22");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void phoneWithLettersShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setPhone("abs");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithLessThanNineDigitsShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setPhone("123124");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithMoreThanNineDigitsShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setPhone("1234567890");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneNotStartingWithNineShouldNotAllow(){
        TutorEntity tutorEntity = new TutorEntity();
        tutorEntity.setPhone("123456789");
        Set<ConstraintViolation<TutorEntity>> violation = this.validator.validate(tutorEntity);
        assertFalse(violation.isEmpty());
    }
}
