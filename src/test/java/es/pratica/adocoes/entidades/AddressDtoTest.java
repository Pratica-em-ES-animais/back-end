package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.Test;
import es.pratica.adocoes.aplicacao.dtos.AddressDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class AddressDtoTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();

    @Test
    public void emtpyCepShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCep("");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void cepWithLessThanEigthNumbersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCep("21");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }
     
    @Test
    public void cepMoreWithLettersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCep("NRS");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void cepWithEigthNumbersShouldAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCep("90520000");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void ufWithNumbersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setUf("123");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    
    @Test
    public void ufWithMoreThanTwoDigitsShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setUf("ABC");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void validUfShouldAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setUf("AB");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertTrue(violation.isEmpty()); 
    }

    @Test
    public void cidadeWithNumbersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCidade("12");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void emptyCidadeShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCidade("");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void cidadeWithFiftyOneLettersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        String cidadeWithFiftyOneLetters = new StringBuilder().repeat("a", 61).toString();
        addressDto.setCidade(cidadeWithFiftyOneLetters);
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void validCidadeShouldAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setCidade("Porto Alegre");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertTrue(violation.isEmpty()); 
    }


    
    @Test
    public void bairroWithNumbersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setBairro("12");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void emptyBairroShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setBairro("");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void bairroWithFiftyOneLettersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        String bairroWithFiftyOneLetters = new StringBuilder().repeat("a", 61).toString();
        addressDto.setBairro(bairroWithFiftyOneLetters);
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void validBairroShouldAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setBairro("Porto Alegre");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertTrue(violation.isEmpty()); 
    } 

    @Test
    public void numeroWithLettersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setNumero("Porto");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void emptyNumeroShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setNumero("");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validNumeroShouldAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setNumero("301");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void logradouroGreaterThanAHundredLettersShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        String logradouro = new StringBuilder().repeat("a", 101).toString();
        addressDto.setLogradouro(logradouro);
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void emptyLogradouroShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setLogradouro("");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validLogradouroShouldNotAllow(){
        AddressDto addressDto = new AddressDto();
        addressDto.setLogradouro("Av. Ipiranga");
        Set<ConstraintViolation<AddressDto>> violation = this.validator.validate(addressDto);
        assertTrue(violation.isEmpty());
    }

}
