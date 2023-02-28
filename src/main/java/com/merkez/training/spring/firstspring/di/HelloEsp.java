package com.merkez.training.spring.firstspring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class HelloEsp implements IHello {

    @Override
    public String sayHello(String name,
                           String surname) {
        return "Ola " + name + " " + surname;
    }

}
