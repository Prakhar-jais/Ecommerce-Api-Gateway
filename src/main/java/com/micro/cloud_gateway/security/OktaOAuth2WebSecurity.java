package com.micro.cloud_gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class OktaOAuth2WebSecurity {
    
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
       
        http
            .authorizeExchange(exchanges -> exchanges
                .anyExchange().authenticated()
            )
            .oauth2Login(withDefaults -> {})
            .oauth2Client(withDefaults -> {})
            .oauth2ResourceServer(oauth2 -> oauth2
            .jwt(withDefaults -> {})) ;
            
        return http.build();
    }
}
