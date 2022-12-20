package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private  String last_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

}
