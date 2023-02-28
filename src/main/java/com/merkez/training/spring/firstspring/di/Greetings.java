package com.merkez.training.spring.firstspring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class Greetings {
    private IHello helloEng;

    @Autowired
    @Qualifier("hhEng")
    private IHello hello2;

    @Autowired
    @Qualifier("helloTr")
    private IHello hello3;

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
