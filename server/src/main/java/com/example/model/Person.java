package com.example.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;

@Entity
public class Person extends PanacheEntityBase {

    private static final String PERSON_SEQ_NAME = "person_seq";

    @Id
    @SequenceGenerator(name = PERSON_SEQ_NAME, sequenceName = PERSON_SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = PERSON_SEQ_NAME, strategy = GenerationType.SEQUENCE)
    public Long id;

    public String givenName;
    public String familyName;
    public LocalDate birthDate;
}
