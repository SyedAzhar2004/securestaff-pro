package com.syedspring.springboot.Thymeleafdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails john = User.withDefaultPasswordEncoder()
                .username("john")
                .password("test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.withDefaultPasswordEncoder()
                .username("mary")
                .password("test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.withDefaultPasswordEncoder()
                .username("susan")
                .password("test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                .requestMatchers("/employees/list").hasRole("EMPLOYEE")
                .requestMatchers("/employees/showFormForAdd/**","/employees/showFormForUpdate/**").hasRole("MANAGER")
                        .requestMatchers("/employees/showFormForDelete/**").hasRole("ADMIN")
                .anyRequest().authenticated())
                        .formLogin(Customizer.withDefaults())  // Enables default login page
                        .logout(logout -> logout.permitAll());
        return http.build();
    }

}
