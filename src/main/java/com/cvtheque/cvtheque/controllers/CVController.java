package com.cvtheque.cvtheque.controllers;

import com.cvtheque.cvtheque.models.CV;
import com.cvtheque.cvtheque.services.CVServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cvtheque.cvtheque.exceptions.NotFoundException;
import com.cvtheque.cvtheque.exceptions.BadRequestException;


@RestController
@RequestMapping("/api/cvs")
public class CVController {
   @Autowired
    private CVServiceImp cvService;

    @PostMapping()
    public ResponseEntity<CV> saveCV(@RequestBody CV cv){
        try{
            return new ResponseEntity<>(cvService.saveCv(cv), HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<CV> updateCV(@PathVariable int id, @RequestBody CV cv){
        try{
            return new ResponseEntity<>(cvService.updateCv(cv), HttpStatus.OK);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CV> deleteCV(@PathVariable int id){
        try{
            cvService.deleteCv(cvService.getCvById(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("There is no CV with id : " + id);
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<CV>> getAllCV(){
        return new ResponseEntity<>(cvService.getAllCv(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CV> getCVById(@PathVariable int id){
        try{
            return new ResponseEntity<>(cvService.getCvById(id), HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("There is no CV with id : " + id);
        }
    }



}
