package com.cvtheque.cvtheque.controllers;

import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.services.LearnerService;
import com.cvtheque.cvtheque.services.LearnerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
            return new ResponseEntity<>(learnerService.saveLearner(learner), HttpStatus.CREATED);
        }

    @GetMapping
    public ResponseEntity<Iterable<Learner>> getAllLearners() {
        Iterable<Learner> learners = learnerService.getAllLearner();
        return ResponseEntity.ok(learners);
    }

        @GetMapping("/{id}")
        public ResponseEntity<Learner> findLearnerById(@PathVariable Integer id){
            return new ResponseEntity<>(learnerService.getLearnerById(id), HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Learner> updateLearner(@PathVariable Integer id, @RequestBody Learner learner){
            return new ResponseEntity<>(learnerService.updateLearner(learner), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteLearner(@PathVariable Integer id){
            learnerService.DeleteLearnerById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


}
