package com.cvtheque.cvtheque.controllers;

import com.cvtheque.cvtheque.models.Trainer;
import com.cvtheque.cvtheque.services.TrainerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.cvtheque.cvtheque.exceptions.BadRequestException;
import com.cvtheque.cvtheque.exceptions.NotFoundException;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {
    @Autowired
    private TrainerServiceImp trainerService;

    @PostMapping()
    public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer){
        try{
            return new ResponseEntity<>(trainerService.saveTrainer(trainer), HttpStatus.CREATED);
        }catch (Exception e){
            throw new BadRequestException("Something wrong in the form or values of the required data");
        }
    }

    @GetMapping()
    public ResponseEntity<Iterable<Trainer>> getAllTrainers(){
        return new ResponseEntity<>(trainerService.getAllTrainer(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> findTrainerById(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(trainerService.getTrainerById(id), HttpStatus.OK);
        }catch(Exception e){
            throw new NotFoundException("There is no trainer with id : " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@RequestBody Trainer updatedTrainer, @PathVariable int id)
    {
        try{
            Trainer trainer = trainerService.getTrainerById(id);
            try{
                trainer.setFirst_name(updatedTrainer.getFirst_name());
                trainer.setLast_name(updatedTrainer.getLast_name());
                trainer.setEmail(updatedTrainer.getEmail());
                trainer.setPassword(updatedTrainer.getPassword());
                return new ResponseEntity<>(trainerService.updateTrainer(trainer), HttpStatus.OK);
            }catch (Exception e){
                throw new BadRequestException("Something wrong in the form or values of the required data");
            }
        }catch (Exception e){
            throw new NotFoundException("There is no trainer with id : " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trainer> deleteTrainer(@PathVariable int id){
        try{
            Trainer trainer = trainerService.getTrainerById(id);
            trainerService.deleteTrainer(trainer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            throw new NotFoundException("There is no trainer with id : " + id);
        }
    }

}
