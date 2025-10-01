package es.pratica.adocoes.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.OngRepoInterface;
import es.pratica.adocoes.dominio.interfacerepositorios.OngRepository;
import es.pratica.adocoes.dominio.modelos.AddressModel;
import es.pratica.adocoes.dominio.modelos.OngModel;

@ActiveProfiles("test")
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class OngRepositoryTest {
    
    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private OngRepoInterface ongRepoMongo;
    
    @AfterEach
    public void cleanDb(){
        this.ongRepoMongo.deleteAll();
    }

    @Test
    public void addingOngShouldChangeDbState(){
        AddressModel addressModel = new AddressModel("90400000", "RS", "Porto Alegre", "Menino Deus",
                                         "", "402", "Avenida Padre Cacique");
        OngModel ongModel= new OngModel("90000110001","Fada Ong", "fada@gmail.com", "51", "982345789", addressModel);
        this.ongRepository.add(ongModel);

        assertNotEquals(0,this.ongRepoMongo.count());
    }
    
    @Test
    public void addingAndGettingShouldReturnOng(){
        AddressModel addressModel = new AddressModel("90400000", "RS", "Porto Alegre", "Menino Deus",
                                         "", "402", "Avenida Padre Cacique");
        OngModel ongModel= new OngModel("90000110001","Fada Ong", "fada@gmail.com", "51", "982345789", addressModel);
        this.ongRepository.add(ongModel);

        assertNotNull(this.ongRepository.getByCnpj(ongModel.getCnpj()));
    }

    @Test 
    public void notAddingAndGettingShouldReturnNull(){
        assertEquals(Optional.empty(),this.ongRepository.getByCnpj(""));
    }

}
