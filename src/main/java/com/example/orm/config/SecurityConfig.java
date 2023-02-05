package com.example.orm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}password")
                .authorities("ROLE_READ")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{noop}password")
                .authorities("ROLE_WRITE","ROLE_READ","ROLE_DELETE")
                .build();
        UserDetails developer = User.withUsername("developer")
                .password("{noop}password")
                .authorities("ROLE_WRITE")
                .build();
        return new InMemoryUserDetailsManager(user, admin,developer);
    }
}


