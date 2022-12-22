package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.repositories.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerServiceImp implements LearnerService {
   @Autowired
    private LearnerRepo learnerRepo;

    public LearnerServiceImp(LearnerRepo learnerRepo) {
        this.learnerRepo = learnerRepo;
    }

    @Override
    public Learner saveLearner(Learner learner) {
        return learnerRepo.save(learner);
    }

    @Override
    public Learner updateLearner(Learner learner) {
        return learnerRepo.save(learner);
    }

    @Override
    public void deleteLearner(Learner learner) {
        learnerRepo.delete(learner);
    }


    public Learner DeleteLearnerById(int id) {
        Learner learner = learnerRepo.findById(id).get();
        learnerRepo.delete(learner);
        return learner;
    }

    @Override
    public Learner getLearnerById(int id) {
        return learnerRepo.findById(id).get();
    }

    @Override
    public Iterable<Learner> getAllLearner() {
        return learnerRepo.findAll();
    }

}

