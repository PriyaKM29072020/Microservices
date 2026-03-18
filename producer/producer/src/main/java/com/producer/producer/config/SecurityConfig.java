package com.producer.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers("/eureka/**").permitAll()
                        .requestMatchers("/oauth2/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/error/**").permitAll()
                        .anyRequest().authenticated()
                )

                //.oauth2ResourceServer(server -> server
                 //       .jwt(Customizer.withDefaults()))
        ;
        return http.build();
    }
}
