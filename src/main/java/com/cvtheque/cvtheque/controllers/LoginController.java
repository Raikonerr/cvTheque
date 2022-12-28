package com.cvtheque.cvtheque.controllers;

import com.cvtheque.cvtheque.exceptions.BadRequestException;
import com.cvtheque.cvtheque.exceptions.NotFoundException;
import com.cvtheque.cvtheque.helpers.JwtUtils;
import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.security.JWTAuthFilter;
import com.cvtheque.cvtheque.services.Auth;
import com.cvtheque.cvtheque.services.LearnerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

@RestController
@RequestMapping(value = "auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LearnerServiceImp learnerService;

    @Autowired
    private AuthenticationManager authenticationManager;
    private UserDetails userDetails;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/learner")
    public ResponseEntity<String> loginLearner(@RequestBody Auth auth) {
        System.out.println("this is login learner");
        setAuthenticationManager(auth.getEmail(), auth.getPassword());
        System.out.println("this is login learner22");
        final Learner _user =  learnerService.findByEmailOrUsername(auth.getEmail());
        final UserDetails userDetails = new org.springframework.security.core.userdetails.User(_user.getEmail(), _user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("LEARNER")));
        if(_user != null){
            System.out.println("user is not null");
            return ResponseEntity.ok( "{\"token\":\""+ jwtUtils.generateToken(userDetails)+"\"}");
        }
        System.out.println("_user " +_user);
        return ResponseEntity.status(400).body("Some error has occurred");
    }

    private void setAuthenticationManager(String email, String password) {
        System.out.println("this is setAuthenticationManager");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        System.out.println("this is login learner auth");
    }

    @GetMapping("/test")
    public String test(){
        return "test hh";
    }

}
