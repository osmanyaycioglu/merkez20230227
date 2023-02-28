package com.merkez.training.spring.firstspring.rest;

import a.b.c.TestBean;
import com.merkez.training.spring.firstspring.di.Greetings;
import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondRest {

    @Autowired
    @Qualifier("tr-gr")
    private IHello hello;

    @GetMapping("/hello")
    public String hello(@RequestParam("na") String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam("na") String name,
                         @RequestParam("sn") String surname) {
        return hello.sayHello(name, surname);
    }

}
