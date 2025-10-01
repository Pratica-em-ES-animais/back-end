package es.pratica.adocoes.servicos;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.OngRepoInterface;
import es.pratica.adocoes.dominio.modelos.AddressModel;
import es.pratica.adocoes.dominio.modelos.OngModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.OngServiceInterface;


@SpringBootTest
@ActiveProfiles("test")
public class OngServiceTests {
    
    @Autowired
    private OngServiceInterface ongService;
    
    @Autowired
    private OngRepoInterface ongRepoMongo;

     
    @AfterEach
    public void cleanDb(){
        this.ongRepoMongo.deleteAll();
    }

    @Test
    public void addingOngShouldReturnIt(){
        AddressModel addressModel = new AddressModel("90400000", "RS", "Porto Alegre", "Menino Deus",
                                         "", "402", "Avenida Padre Cacique");
        OngModel ongModel= new OngModel("90000110001","Fada Ong", "fada@gmail.com", "51", "982345789", addressModel);
        assertNotNull(this.ongService.createOng(ongModel));
    }

    @Test
    public void addingDuplicatedOngShouldReturnNull(){
        AddressModel addressModel = new AddressModel("90400000", "RS", "Porto Alegre", "Menino Deus",
                                         "", "402", "Avenida Padre Cacique");
        OngModel ongModel= new OngModel("90000110001","Fada Ong", "fada@gmail.com", "51", "982345789", addressModel);
        this.ongService.createOng(ongModel);
        assertNull(this.ongService.createOng(ongModel));
    }

    @Test
    public void gettingExistentOngShouldReturn(){
        AddressModel addressModel = new AddressModel("90400000", "RS", "Porto Alegre", "Menino Deus",
                                         "", "402", "Avenida Padre Cacique");
        OngModel ongModel= new OngModel("90000110001","Fada Ong", "fada@gmail.com", "51", "982345789", addressModel);
        this.ongService.createOng(ongModel);
        assertNotNull(this.ongService.getByCnpj(ongModel.getCnpj()));
    }

    @Test
    public void gettingNonExistentOngShouldReturnNull(){
        assertNull(this.ongService.getByCnpj(""));
    }
}
