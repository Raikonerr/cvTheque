package com.cvtheque.cvtheque.controllers;

import com.cvtheque.cvtheque.exceptions.BadRequestException;
import com.cvtheque.cvtheque.exceptions.NotFoundException;
import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.services.LearnerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/api/learners")
public class LearnerController {
    @Autowired
    private LearnerServiceImp learnerService;

        @PostMapping()
        public ResponseEntity<Learner> saveLearner(@RequestBody Learner learner){
            try{
            return new ResponseEntity<>(learnerService.saveLearner(learner), HttpStatus.CREATED);
            }catch (Exception e){
                throw new BadRequestException("Something wrong in the form or values of the required data");
            }
        }

    @GetMapping
    public ResponseEntity<Iterable<Learner>> getAllLearners() {
        Iterable<Learner> learners = learnerService.getAllLearner();
        return ResponseEntity.ok(learners);
    }

        @GetMapping("/{id}")
        public ResponseEntity<Learner> findLearnerById(@PathVariable Integer id){
            try {
                return new ResponseEntity<>(learnerService.getLearnerById(id), HttpStatus.OK);
            }catch(Exception e){
                throw new NotFoundException("There is no learner with id : " + id);
            }
        }

        @PutMapping("/{id}")
      public ResponseEntity<Learner> updateLearner(@RequestBody Learner updatedLearner, @PathVariable int id)
        {
            try{
                Learner learner = learnerService.getLearnerById(id);
                try{
                    learner.setFirst_name(updatedLearner.getFirst_name());
                    learner.setLast_name(updatedLearner.getLast_name());
                    learner.setEmail(updatedLearner.getEmail());
                    learner.setPassword(updatedLearner.getPassword());
                    return new ResponseEntity<>(learnerService.updateLearner(learner), HttpStatus.OK);
                }catch (Exception e){
                    throw new BadRequestException("Something wrong in the form or values of the required data");
                }
            }catch (Exception e){
                throw new NotFoundException("There is no learner with id : " + id);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteLearner(@PathVariable Integer id){
            try{
                //find the learner
                learnerService.getLearnerById(id);
                try {
                    //delete the learner
                    learnerService.DeleteLearnerById(id);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }catch(Exception e){
                    throw new BadRequestException("Something wrong in the form or values of the required data");
                }
            }catch(Exception e){
                throw new NotFoundException("There is no learner with id : " + id);
            }
        }

}
