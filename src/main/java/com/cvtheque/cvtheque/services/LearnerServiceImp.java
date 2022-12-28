package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.repositories.LearnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Learner findByEmailOrUsername(String email) {
        System.out.println("this is findByEmailOrUsername");
    Learner learner =  learnerRepo.findByEmail(email).get();
        System.out.println("hada learner "+learner);
        return learner;
    }


    public Learner DeleteLearnerById(int id) {
        Learner learner = learnerRepo.findById(id).get();
        learnerRepo.delete(learner);
        return learner;
    }

    @Override
    public Learner getLearnerById(int id) {
         Optional<Learner> learner = learnerRepo.findById(id);
         return learner.get();
    }

    @Override
    public Iterable<Learner> getAllLearner() {
        return learnerRepo.findAll();
    }

    @Override
    public Learner FindLearnerByEmailOrUser(String email) {
        return null;
    }

}

