package com.merkez.training.spring.firstspring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("hhEng")
@Qualifier("en-gr")
public class HelloEng implements IHello {

    @Override
    public String sayHello(String name,
                           String surname) {
        return "Hello " + name + " " + surname;
    }

}
