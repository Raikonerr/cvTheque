package com.cvtheque.cvtheque.security;

import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.services.LearnerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    @Autowired
    private final JWTAuthFilter jwtAuthFilter;

    @Autowired
    private final LearnerServiceImp learnerServiceImp;
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    System.out.println("securityFilterChain");

         http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**","/test")
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .and().authorizeHttpRequests()
                .requestMatchers("/api/learners/**").hasAnyAuthority("LEARNER")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/trainers/**").hasAnyAuthority("TRAINER")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/cvs/**").hasAnyAuthority("LEARNER","TRAINER","CME")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/cme/**").hasAnyAuthority("CME")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/comments/**").hasAnyAuthority("LEARNER","TRAINER","CME")
                .anyRequest()
                .authenticated()
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        System.out.println("userDetailsService");
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Learner learner= learnerServiceImp.findByEmailOrUsername(email);

                if(learner==null){
                    return null;
                }
                UserDetails user = new User(learner.getEmail(),learner.getPassword(), Collections.singleton(new SimpleGrantedAuthority("LEARNER")));
                System.out.println(user.getUsername());
                return user;
            }
        };
    }
}
