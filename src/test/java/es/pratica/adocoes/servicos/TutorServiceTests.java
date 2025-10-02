package es.pratica.adocoes.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.adaptadores.persistencia.entidades.OngEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.OngRepoInterface;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.TutorRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.OngRepository;
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

    @Autowired
    private TutorRepoInterface tutorRepoInterface;

    @Autowired
    private OngRepoInterface ongRepoMongo;

    private OngModel ongModel;
    
    @AfterEach
    public void cleanDb(){
        this.tutorRepoInterface.deleteAll();
        this.ongRepoMongo.deleteAll();
    }

    @BeforeEach
    public void setup(){
        AddressModel addressModel = new AddressModel("90400000", "RS", "Porto Alegre", "Menino Deus",
                                         "", "402", "Avenida Padre Cacique");
        ongModel= new OngModel("90000110001","Fada Ong", "fada@gmail.com", "51", "982345789", addressModel);
        this.ongModel = OngModel.toModel(this.ongRepoMongo.save(OngEntity.fromModel(ongModel)));
    }

    @Test
    public void shouldAddTutor(){
        TutorModel tutor = new TutorModel("60238940015", "Juninho", "Paulista", "juninho@gmail.com","51","981230034", "juninhoJogador", this.ongModel);
        var response = this.tutorServiceInterface.createTutor(tutor);
        assertNotNull(response);
    }

    
    @Test
    public void shouldNotAddTutor(){
        TutorModel tutor = new TutorModel("60238940015", "Juninho", "Paulista", "juninho@gmail.com","51","981230034", "juninhoJogador", this.ongModel);
        this.tutorServiceInterface.createTutor(tutor);
        var response = this.tutorServiceInterface.createTutor(tutor);
        assertNull(response);
    }
}




