package com.cvtheque.cvtheque.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;


@Entity
public class Cme extends Person{

    @OneToMany(mappedBy = "cme")
    private List<Comment> comments;

    public Cme(String first_name, String last_name, String email, String password) {
        super(first_name, last_name, email, password);
    }

    public Cme() {
    }
}
