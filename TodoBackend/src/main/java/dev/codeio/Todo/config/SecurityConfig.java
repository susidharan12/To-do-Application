package dev.codeio.Todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",                       // ROOT URL
                                "/index.html",             // If static page exists
                                "/auth/**",                // Login/Register
                                "/api/v1/todo/**",         // Todo APIs
                                "/swagger-ui/**",          // Swagger UI
                                "/v3/api-docs/**"          // Swagger JSON
                        ).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
