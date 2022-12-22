package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.Trainer;
import com.cvtheque.cvtheque.repositories.TrainerRepo;

public interface TrainerService {
    Trainer saveTrainer(Trainer trainer);
    Trainer updateTrainer(Trainer trainer);
    void deleteTrainer(Trainer trainer);
    Trainer getTrainerById(int id);
    Iterable<Trainer> getAllTrainer();
}
