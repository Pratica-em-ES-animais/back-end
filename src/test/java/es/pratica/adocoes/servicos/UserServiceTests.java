package es.pratica.adocoes.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.UserServiceInterface;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
public class UserServiceTests {
    @Autowired
    private UserServiceInterface userService;
    private UserModel um;
    
    @BeforeAll
    public void init(){
        MockitoAnnotations.openMocks(this);
        this.um = new UserModel("12345678910", "Ronaldinho", "Gaucho","ronaldinho@gmail.com", "51", "981230036", "interCampeaoDoMundo");
    }
    
    @Test
    public void shouldAddUser(){
        var response = this.userService.createUser(um);
        this.um = response;
        assertNotNull(response);
    }


    @Test
    public void shouldRemove(){
        var response = this.userService.createUser(um);
        this.userService.removeAll();
        var user = this.userService.getById(response.getId());
        Optional<UserModel> actual = Optional.empty();
        assertEquals(actual, user);
    }

    @Test
    public void shouldNotBeNull(){
        var response = this.userService.createUser(um);
        var expected = this.userService.getByEmail(response.getEmail());
        Optional<UserModel> actual = Optional.of(response);
        assertEquals(actual,expected);
    }
    
}
