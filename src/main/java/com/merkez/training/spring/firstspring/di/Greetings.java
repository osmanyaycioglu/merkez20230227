package com.merkez.training.spring.firstspring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Greetings {
    private IHello helloEng;

    @Autowired
    public Greetings(@Qualifier("en-gr") IHello helloEngParam) {
        helloEng = helloEngParam;
    }

    public void greet(String name,
                      String surname) {
        System.out.println(helloEng.sayHello(name,
                                             surname));
    }
}
