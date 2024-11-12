package com.incb.store_content_manager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests((authenticator) -> authenticator.anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .build();


//        return httpSecurity
//                .authorizeHttpRequests(
//                        authenticator -> authenticator
//                        .requestMatchers("/")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                )
//                .oauth2Login(oauth -> oauth.defaultSuccessUrl("/",true))
//                .formLogin(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable)
//                .build();
    }

}
