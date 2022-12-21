package com.cvtheque.cvtheque.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("trainer")
public class Trainer extends Person {
    // fields and methods for the Trainer entity
}

