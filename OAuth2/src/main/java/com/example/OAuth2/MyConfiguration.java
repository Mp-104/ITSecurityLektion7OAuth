package com.example.OAuth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfiguration {

    @Bean
    public SecurityFilterChain getSecurityFilterChain (HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/").permitAll()
                    .anyRequest().authenticated();

        }).oauth2Login(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/perform_logout")
                        .logoutSuccessUrl("/login")
                        .permitAll());

        //httpSecurity.oauth2Login(Customizer.withDefaults());

        return httpSecurity.build();

    }

    @Bean
    public ClientRegistrationRepository repository () {

        ClientRegistrationRepository repository = new ClientRegistrationRepository() {
            @Override
            public ClientRegistration findByRegistrationId(String registrationId) {
                return null;
            }
        };

        return repository;
    }

}
