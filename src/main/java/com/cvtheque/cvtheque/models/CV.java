package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class CV {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "learner_id")
    private Learner learner;

    // other fields and methods for the CV entity
}
