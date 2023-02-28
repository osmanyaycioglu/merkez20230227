package com.merkez.training.spring.firstspring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GreetRunner implements CommandLineRunner {
    private Greetings greetings;

    @Autowired
    public GreetRunner(Greetings greetingsParam) {
        greetings = greetingsParam;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------");
        greetings.greet("osman", "yaycıoğlu");
        System.out.println("-----------------");
    }
}
