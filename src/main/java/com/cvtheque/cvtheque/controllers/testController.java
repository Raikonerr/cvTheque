package com.cvtheque.cvtheque.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping(value = "test")
public class testController {

    @GetMapping()
    public String test(){
        return "test";
    }
}
