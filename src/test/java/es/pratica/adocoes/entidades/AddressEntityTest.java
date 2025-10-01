package es.pratica.adocoes.entidades;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AddressEntity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class AddressEntityTest {
    private final Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();

    @Test
    public void emtpyCepShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCep("");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void cepWithLessThanEigthNumbersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCep("21");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }
     
    @Test
    public void cepMoreWithLettersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCep("NRS");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void cepWithEigthNumbersShouldAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCep("90520000");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void ufWithNumbersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUf("123");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    
    @Test
    public void ufWithMoreThanTwoDigitsShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUf("ABC");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void validUfShouldAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUf("AB");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertTrue(violation.isEmpty()); 
    }

    @Test
    public void cidadeWithNumbersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCidade("12");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void emptyCidadeShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCidade("");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void cidadeWithFiftyOneLettersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        String cidadeWithFiftyOneLetters = new StringBuilder().repeat("a", 61).toString();
        addressEntity.setCidade(cidadeWithFiftyOneLetters);
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void validCidadeShouldAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCidade("Porto Alegre");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertTrue(violation.isEmpty()); 
    }


    
    @Test
    public void bairroWithNumbersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBairro("12");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void emptyBairroShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBairro("");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void bairroWithFiftyOneLettersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        String bairroWithFiftyOneLetters = new StringBuilder().repeat("a", 61).toString();
        addressEntity.setBairro(bairroWithFiftyOneLetters);
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty()); 
    }

    @Test
    public void validBairroShouldAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setBairro("Porto Alegre");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertTrue(violation.isEmpty()); 
    } 

    @Test
    public void numeroWithLettersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setNumero("Porto");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }
    
    @Test
    public void emptyNumeroShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setNumero("");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validNumeroShouldAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setNumero("301");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertTrue(violation.isEmpty());
    }

    @Test
    public void logradouroGreaterThanAHundredLettersShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        String logradouro = new StringBuilder().repeat("a", 101).toString();
        addressEntity.setLogradouro(logradouro);
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void emptyLogradouroShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setLogradouro("");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertFalse(violation.isEmpty());
    }

    @Test
    public void validLogradouroShouldNotAllow(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setLogradouro("Av. Ipiranga");
        Set<ConstraintViolation<AddressEntity>> violation = this.validator.validate(addressEntity);
        assertTrue(violation.isEmpty());
    }

}
