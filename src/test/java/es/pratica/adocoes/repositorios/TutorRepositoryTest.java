package es.pratica.adocoes.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import es.pratica.adocoes.adaptadores.persistencia.entidades.OngEntity;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.OngRepoInterface;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.TutorRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.TutorRepository;
import es.pratica.adocoes.dominio.modelos.AddressModel;
import es.pratica.adocoes.dominio.modelos.OngModel;
import es.pratica.adocoes.dominio.modelos.TutorModel;

@ActiveProfiles("test")
@SpringBootTest
public class TutorRepositoryTest {
    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private TutorRepoInterface tutorRepoMongo;
    
    @Autowired
    private OngRepoInterface ongRepoMongo;

    private OngModel ongModel;

    @AfterEach
    public void cleanDb(){
        this.tutorRepoMongo.deleteAll();
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
    public void addingTutorShouldChangeDbState(){
        TutorModel tutorModel = new TutorModel("60130025022", "Alan Patrick", "Lourenço", 
                                             "alanpa@gmail.com", "51", "920004567", "alanpa", this.ongModel);
        this.tutorRepository.add(tutorModel);
        assertNotEquals(0,this.tutorRepoMongo.count());
    }

    @Test
    public void gettingByEmailShouldReturnNotNull(){
        TutorModel tutorModel = new TutorModel("60130025022", "Alan Patrick", "Lourenço", 
                                             "alanpa@gmail.com", "51", "920004567", "alanpa", this.ongModel);
        this.tutorRepository.add(tutorModel);
        assertNotNull(this.tutorRepository.getByEmail(tutorModel.getEmail()));
    }

    @Test
    public void gettingByEmailShouldReturnNull(){
        TutorModel tutorModel = new TutorModel("60130025022", "Alan Patrick", "Lourenço", 
                                             "alanpa@gmail.com", "51", "920004567", "alanpa", this.ongModel);
        assertEquals(Optional.empty(),this.tutorRepository.getByEmail(tutorModel.getEmail()));
    }


}
