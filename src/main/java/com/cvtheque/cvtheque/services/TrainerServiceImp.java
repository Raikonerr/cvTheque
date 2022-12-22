package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.Trainer;
import com.cvtheque.cvtheque.repositories.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TrainerServiceImp implements TrainerService {
   @Autowired
    private TrainerRepo trainerRepo;

    public TrainerServiceImp(TrainerRepo trainerRepo) {
        this.trainerRepo = trainerRepo;
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    @Override
    public void deleteTrainer(Trainer trainer) {
        trainerRepo.delete(trainer);
    }

    @Override
    public Trainer getTrainerById(int id) {
        return trainerRepo.findById(id).get();
    }

    @Override
    public Iterable<Trainer> getAllTrainer() {
        return trainerRepo.findAll();
    }
}

