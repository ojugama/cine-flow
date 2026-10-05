package co.edu.cineflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para permitir peticiones POST sin token
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite el acceso a todo el mundo por ahora
                );

        return http.build();
    }
}
