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

}
