package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CV {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "learner_id")
    private Learner learner;

    @OneToMany(mappedBy = "cv")
    private List<Comment> comments;
    // other fields and methods for the CV entity
}
