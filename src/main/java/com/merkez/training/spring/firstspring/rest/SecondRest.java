package com.merkez.training.spring.firstspring.rest;

import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/second")
public class SecondRest {

    @Autowired
    @Qualifier("helloTr")
    private IHello hello;

    @Autowired
    private IHello helloTr;

    @Autowired
    private IHello[] hellos;

    @GetMapping("/hello")
    public String hello(@RequestParam("na") String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello2")
    public String hello2(@RequestParam("na") String name,
                         @RequestParam("sn") String surname) {
        return hello.sayHello(name,
                              surname);
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("na") String name,
                         @RequestParam("sn") String surname,
                         @RequestParam("age") Integer age) {
        return hello.sayHello(name,
                              surname) + " " + age;
    }

    @GetMapping("/hello4")
    public String hello4(@RequestParam("na") String name,
                         @RequestParam("sn") String surname,
                         @RequestParam("birth") LocalDate birthdate) {
        return hello.sayHello(name,
                              surname) + " " + birthdate;
    }

}
