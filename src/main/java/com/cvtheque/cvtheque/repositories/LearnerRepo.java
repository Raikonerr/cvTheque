package com.cvtheque.cvtheque.repositories;

import com.cvtheque.cvtheque.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LearnerRepo extends JpaRepository<Learner,Integer> {
    @Query("SELECT l FROM Learner l WHERE l.email=?1")
    Optional<Learner> findByEmail(String email);
}

