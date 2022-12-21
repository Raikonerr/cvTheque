package com.cvtheque.cvtheque.controllers;


import com.cvtheque.cvtheque.services.CmeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cmes")
public class CmeController {

    private CmeService cmeService;

    public CmeController(CmeService cmeService){
        this.cmeService = cmeService;
    }


}
