package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("trainer")
public class Trainer extends Person {
    // fields and methods for the Trainer entity


    public Trainer(String first_name, String last_name, String email, String password) {
        super(first_name, last_name, email, password);
    }

    public Trainer() {
    }
}

