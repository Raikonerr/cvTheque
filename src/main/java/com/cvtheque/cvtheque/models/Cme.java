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

}
