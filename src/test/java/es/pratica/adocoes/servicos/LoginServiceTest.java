package es.pratica.adocoes.servicos;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.pratica.adocoes.adaptadores.persistencia.interfacesdb.UserRepoInterface;
import es.pratica.adocoes.aplicacao.casosdeuso.LoginUserUC;
import es.pratica.adocoes.aplicacao.dtos.UserLoginDto;
import es.pratica.adocoes.dominio.enums.Role;
import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.UserServiceInterface;

@SpringBootTest
@ActiveProfiles("test")
public class LoginServiceTest {
    @Autowired
    private LoginUserUC loginUserUC;
    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserRepoInterface mongoRepo;

    @AfterEach
    public void cleanDb(){
        mongoRepo.deleteAll();
    }

    @Test
    public void loginWithWrongPasswordShouldReturnNull(){
        var um = new UserModel("12345678910", "Ronaldinho", "Gaucho","ronaldinho@gmail.com", "51", "981230036", "interCampeaoDoMundo", Role.USER);
        userService.createUser(um);
        assertNull(this.loginUserUC.login(new UserLoginDto("ronaldinho@gmail.com", "null")));
    }

    @Test
    public void loginWithCorrectPasswordShouldReturnNotNull(){
        var um = new UserModel("12345678910", "Ronaldinho", "Gaucho","ronaldinho@gmail.com", "51", "981230036", "interCampeaoDoMundo", Role.USER);
        userService.createUser(um);
        assertNotNull(this.loginUserUC.login(new UserLoginDto("ronaldinho@gmail.com", "interCampeaoDoMundo")));
    }
}
