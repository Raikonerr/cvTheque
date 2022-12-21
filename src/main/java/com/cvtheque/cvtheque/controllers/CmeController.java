package com.cvtheque.cvtheque.controllers;


import com.cvtheque.cvtheque.models.Cme;
import com.cvtheque.cvtheque.services.CmeService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cmes")
public class CmeController {

    private CmeService cmeService;

    public CmeController(CmeService cmeService){
        this.cmeService = cmeService;
    }

    @PostMapping()
    public ResponseEntity<Cme> saveCme(@RequestBody Cme cme){
          return new ResponseEntity<>(cmeService.save(cme), HttpStatus.CREATED);
    }


}
