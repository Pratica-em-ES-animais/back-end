package es.pratica.adocoes.repositorios;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.UserServiceInterface;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTests {
    @Autowired
    private UserServiceInterface userService;
    private UserModel um;
    

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.um = new UserModel("12345678910", "Ronaldinho", "Gaucho","ronaldinho@gmail.com", "51", "981230036", "interCampeaoDoMundo");
    }

    @Test
    public void shouldAddUser(){
        var response = this.userService.createUser(um);

        assertNotNull(response);
    }


    @Test
    public void shouldRemove(){
        this.userService.removeAll();
        var user = this.userService.getById(this.um.getId());
        assertNull(user);
    }
    
}
