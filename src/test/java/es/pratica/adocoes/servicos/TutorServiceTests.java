package es.pratica.adocoes.servicos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.dominio.servicos.interfaceservice.TutorServiceInterface;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class TutorServiceTests {

    @Autowired
    private TutorServiceInterface tutorServiceInterface;

    @Test
    public void shouldAddTutor(){
        
    }

    
    @Test
    public void shouldNotAddTutor(){
        
    }
    
    
    @Test
    public void shouldReturnTutor(){
        
    }


}




