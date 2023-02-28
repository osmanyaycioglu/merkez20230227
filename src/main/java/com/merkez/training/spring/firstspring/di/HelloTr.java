package com.merkez.training.spring.firstspring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tr-gr")
public class HelloTr implements IHello {

    @Override
    public String sayHello(String name,
                           String surname) {
        return "Selam " + name + " " + surname;
    }

}
