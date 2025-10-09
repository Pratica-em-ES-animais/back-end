package es.pratica.adocoes.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SpringSecurityConfig {
   
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(requests -> requests.
                                                        requestMatchers(
                                            "/api/user/create",
                                                        "/api/adoption/create",
                                                        "/swagger-ui/**",
                                                        "/v3/api-docs/**",
                                                        "/api/tutor/create",
                                                        "/",
                                                        "/auth/**")
                                                        .permitAll()
                                                        .anyRequest()
                                                        .permitAll());
        http.csrf(csrf -> csrf.disable());
       // http.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
        http.formLogin(df -> df.disable()); 
        http.httpBasic(df -> Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
