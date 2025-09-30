package es.pratica.adocoes.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.dominio.modelos.AddressModel;
import es.pratica.adocoes.dominio.modelos.OngModel;
import es.pratica.adocoes.dominio.modelos.TutorModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.TutorServiceInterface;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class TutorServiceTests {

    @Autowired
    private TutorServiceInterface tutorServiceInterface;

    @Test
    public void shouldAddTutor(){
        AddressModel addressModel = new AddressModel("90000420", "RS", "Porto Alegre", "Azenha", "", "401", "Avenida da Azenha");
        OngModel ongModel = new OngModel("134000001","Ong Fada", "fada@gmail.com", "51", "987123456", addressModel);
        TutorModel tutor = new TutorModel("60238940015", "Juninho", "Paulista", "juninho@gmail.com","51","981230034", "juninhoJogador", ongModel);
        
        var response = this.tutorServiceInterface.createTutor(tutor);
        assertNotNull(response);
    }

    
    @Test
    public void shouldNotAddTutor(){
        AddressModel addressModel = new AddressModel("90000420", "RS", "Porto Alegre", "Azenha", "", "401", "Avenida da Azenha");
        OngModel ongModel = new OngModel("134000001","Ong Fada", "fada@gmail.com", "51", "987123456", addressModel);
        TutorModel tutor = new TutorModel("60238940015", "Juninho", "Paulista", "juninho@gmail.com","51","981230034", "juninhoJogador", ongModel);
        this.tutorServiceInterface.createTutor(tutor);
        var response = this.tutorServiceInterface.createTutor(tutor);
        assertNull(response);
    }
    
    
    @Test
    public void shouldReturnTutor(){
        AddressModel addressModel = new AddressModel("90000420", "RS", "Porto Alegre", "Azenha", "", "401", "Avenida da Azenha");
        OngModel ongModel = new OngModel("134000001","Ong Fada", "fada@gmail.com", "51", "987123456", addressModel);
        TutorModel tutor = new TutorModel("60238940015", "Juninho", "Paulista", "juninho@gmail.com","51","981230034", "juninhoJogador", ongModel);
        this.tutorServiceInterface.createTutor(tutor);

        var response = this.tutorServiceInterface.getByEmail(tutor.getEmail());
        assertEquals(tutor, response.get());
    }


}




