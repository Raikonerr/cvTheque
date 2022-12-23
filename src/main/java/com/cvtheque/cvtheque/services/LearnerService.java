package com.cvtheque.cvtheque.services;

import com.cvtheque.cvtheque.models.Learner;
import com.cvtheque.cvtheque.repositories.LearnerRepo;

public interface LearnerService {
    Learner saveLearner(Learner learner);
    Learner updateLearner(Learner learner);
    void deleteLearner(Learner learner);
    Learner getLearnerById(int id);
    Iterable<Learner> getAllLearner();
}
