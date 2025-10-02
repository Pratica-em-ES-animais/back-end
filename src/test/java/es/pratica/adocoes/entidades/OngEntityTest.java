package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;
import es.pratica.adocoes.adaptadores.persistencia.entidades.OngEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class OngEntityTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();
         
    @Test
    public void emtpyCnpjShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setCnpj("");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }
    
           
    @Test
    public void cnpjWithLettersShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setCnpj("asdasd");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void cnpjWithLessThanElevenDigitsShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setCnpj("1112223339");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }


    @Test
    public void cnpjWithElevenDigitsShouldAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setCnpj("11122233311");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void emptyNameShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setName("");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void nameWithNumbersShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setName("13212");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void nameWithMoreThanSixtyLettersShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        String nameWithSixtyOneLetters = new StringBuilder().repeat("a", 61).toString();
        ongEntity.setName(nameWithSixtyOneLetters);
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void nameWithBlankSpacesShouldAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setName("Joao Pedro");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void nameSpecialCharsShouldAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setName("João Pedro");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void regularNameShouldAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setName("Joao");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void invalidEmailShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setEmail("Joao");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validEmailShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setEmail("joao@gmail.com");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void dddWithLettersShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setDdd("SA");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithMoreThanTwoDigitsShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setDdd("222");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithTwoDigitsShouldAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setDdd("22");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void phoneWithLettersShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setPhone("abs");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithLessThanNineDigitsShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setPhone("123124");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithMoreThanNineDigitsShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setPhone("1234567890");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneNotStartingWithNineShouldNotAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setPhone("123456789");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void validPhoneShouldAllow(){
        OngEntity ongEntity = new OngEntity();
        ongEntity.setPhone("923456789");
        Set<ConstraintViolation<OngEntity>> violation = this.validator.validate(ongEntity);
        assertTrue(violation.isEmpty());
    }

}
