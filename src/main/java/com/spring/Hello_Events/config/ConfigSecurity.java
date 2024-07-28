package com.spring.Hello_Events.config;

import com.spring.Hello_Events.service.UserDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    private final UserDetailsImpl userDetailsService;

    public ConfigSecurity(UserDetailsImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(expressionInterceptUrlRegistry ->
                        expressionInterceptUrlRegistry
                                .requestMatchers("/api/user/login", "/api/user/signup").permitAll()
                                .requestMatchers(HttpMethod.DELETE ,  "/api/user/delete/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/events/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/reservations/**").hasRole("USER")
                                .requestMatchers("/api/events/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/api/contact/**").hasRole("USER")
                                .requestMatchers(HttpMethod.GET,"/api/contact/get_all").hasRole("ADMIN")
                                .requestMatchers("/api/contact/**").hasAnyRole("USER","ADMIN")
                                .requestMatchers("/api/reservations/**").hasAnyRole("USER","ADMIN")
                                .anyRequest().permitAll()
                )
                .formLogin(formLogin -> formLogin.disable());
                http.cors(AbstractHttpConfigurer::disable);
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
