package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class Person{
    public Person(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Person() {
    }

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
