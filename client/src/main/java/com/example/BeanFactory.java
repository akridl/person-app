package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.util.Random;

@ApplicationScoped
public class BeanFactory {

    @Produces
    @ApplicationScoped
    public Random random() {
        return new Random();
    }
}
