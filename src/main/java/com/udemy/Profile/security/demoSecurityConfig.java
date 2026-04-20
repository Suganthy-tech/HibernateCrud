package com.udemy.Profile.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class demoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john= User.builder().username("john").password("{noop}test123").roles("Employee").build();
        UserDetails mary= User.builder().username("mary").password("{noop}test123").roles("Employee","Manager").build();
        UserDetails susan= User.builder().username("susan").password("{noop}test123").roles("Employee","Manager","Admin").build();
return new InMemoryUserDetailsManager(john,mary,susan);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->configurer
                .requestMatchers(HttpMethod.GET,"/instructor").hasRole("Employee")
                .requestMatchers(HttpMethod.POST,"/instructor").hasRole("Manager")
                .requestMatchers(HttpMethod.DELETE,"/instructor/**").hasRole("Admin"));
http.httpBasic(Customizer.withDefaults());
http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
