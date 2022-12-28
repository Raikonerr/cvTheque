package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@DiscriminatorValue("learner")
public class Learner extends Person {
    @Lob
    private byte[] coverLetter;

    @ElementCollection
    private Set<String> technicalSkills;

    @ElementCollection
    private Set<String> softSkills;

    private boolean hasJob;

    @OneToOne(mappedBy = "learner")
    private CV cv;

    public Learner(String first_name, String last_name, String email, String password, byte[] coverLetter, boolean hasJob) {
        super(first_name, last_name, email, password);
        this.coverLetter = coverLetter;
        this.hasJob = hasJob;
    }

    public Learner() {
    }
}
