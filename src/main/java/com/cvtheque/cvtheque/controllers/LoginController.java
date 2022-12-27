package com.cvtheque.cvtheque.controllers;

import com.cvtheque.cvtheque.exceptions.BadRequestException;
import com.cvtheque.cvtheque.exceptions.NotFoundException;
import com.cvtheque.cvtheque.helpers.JwtUtils;
import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.security.JWTAuthFilter;
import com.cvtheque.cvtheque.services.LearnerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LearnerServiceImp learnerService;

    private AuthenticationManager authenticationManager;
    private UserDetails userDetails;

    private JwtUtils jwtUtils;

    @PostMapping("/student")
    public ResponseEntity<String> loginLearner(@RequestBody String email,@RequestBody String password ) {
        System.out.println("this is login learner");
        setAuthenticationManager(email, password);
        final UserDetails user = (UserDetails) learnerService.findByEmailOrUsername(email);
        if(user != null){
            return ResponseEntity.ok( "{\"token\":\""+ jwtUtils.generateToken(user)+"\"}");
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }

    private void setAuthenticationManager(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
    }

    @GetMapping("/test")
    public String test(){
        return "test hh";
    }

}
