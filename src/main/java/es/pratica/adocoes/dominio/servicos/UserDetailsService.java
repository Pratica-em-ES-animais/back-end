package es.pratica.adocoes.dominio.servicos;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import es.pratica.adocoes.dominio.interfacerepositorios.UserRepository;
import es.pratica.adocoes.dominio.modelos.UserModel;
import es.pratica.adocoes.dominio.servicos.interfaceservice.UserDetailsServiceInterface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsService implements UserDetailsServiceInterface{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = this.userRepository.getByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
        return User.builder()
                   .username(user.getEmail())
                   .username(user.getSenha())
                   .roles("USER")
                   .build();
        
    }
    
}
