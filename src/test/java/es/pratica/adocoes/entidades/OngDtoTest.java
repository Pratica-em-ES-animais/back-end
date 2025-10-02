package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;

import es.pratica.adocoes.aplicacao.dtos.OngDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class OngDtoTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();
         
    @Test
    public void emtpyCnpjShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setCnpj("");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }
    
           
    @Test
    public void cnpjWithLettersShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setCnpj("asdasd");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void cnpjWithLessThanElevenDigitsShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setCnpj("1112223339");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }


    @Test
    public void cnpjWithElevenDigitsShouldAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setCnpj("11122233311");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void emptyNameShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setName("");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void nameWithNumbersShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setName("13212");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void nameWithMoreThanSixtyLettersShouldNotAllow(){
        OngDto ongDto = new OngDto();
        String nameWithSixtyOneLetters = new StringBuilder().repeat("a", 61).toString();
        ongDto.setName(nameWithSixtyOneLetters);
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void nameWithBlankSpacesShouldAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setName("Joao Pedro");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void nameSpecialCharsShouldAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setName("João Pedro");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void regularNameShouldAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setName("Joao");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void invalidEmailShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setEmail("Joao");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validEmailShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setEmail("joao@gmail.com");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void dddWithLettersShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setDdd("SA");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithMoreThanTwoDigitsShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setDdd("222");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void dddWithTwoDigitsShouldAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setDdd("22");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void phoneWithLettersShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setPhone("abs");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithLessThanNineDigitsShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setPhone("123124");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneWithMoreThanNineDigitsShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setPhone("1234567890");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void phoneNotStartingWithNineShouldNotAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setPhone("123456789");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void validPhoneShouldAllow(){
        OngDto ongDto = new OngDto();
        ongDto.setPhone("923456789");
        Set<ConstraintViolation<OngDto>> violation = this.validator.validate(ongDto);
        assertTrue(violation.isEmpty());
    }

}
