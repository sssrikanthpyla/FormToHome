package com.formtohome.formtohome;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthConverter jwtAuthConverter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf
                                                .disable())
                                .authorizeHttpRequests(requests -> requests
                                                .anyRequest()
                                                .authenticated());

                http
                                .oauth2ResourceServer(s -> s
                                                .jwt()
                                                .jwtAuthenticationConverter(jwtAuthConverter));

                http
                                .sessionManagement(management -> management
                                                .sessionCreationPolicy(STATELESS));

                return http.build();
        }
}
