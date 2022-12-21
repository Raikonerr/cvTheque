package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    private Cme cme;

    @ManyToOne
    private CV cv;
}
