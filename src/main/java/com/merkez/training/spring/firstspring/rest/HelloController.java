package com.merkez.training.spring.firstspring.rest;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    @Qualifier("helloTe")
    private IHello hello;

    @Autowired
    @Qualifier("helloDefault")
    private IHello helloDefault;


    @GetMapping("/hello")
    public String xyz(@RequestParam("na") String name,
                      @RequestParam("sn") String surname) {
        return hello.sayHello(name,
                              surname);
    }

    @GetMapping("/default")
    public String abc(@RequestParam("na") String name,
                      @RequestParam("sn") String surname) {
        return helloDefault.sayHello(name,
                                     surname);
    }

    @GetMapping("/hello2/{rty}/{ghj}")
    public String hello2(@PathVariable("rty") String name,
                         @PathVariable("ghj") String surname) {
        return "2 " + hello.sayHello(name,
                                     surname);
    }

    @GetMapping("/hello3/{name}/{surname}")
    public String hello3(@PathVariable String name,
                         @PathVariable String surname) {
        return "3 " + hello.sayHello(name,
                                     surname);
    }

    @GetMapping("/hello4/{name}/{surname}")
    public String hello4(@PathVariable("name") String name,
                         @PathVariable("surname") String surname) {
        return "4 " + hello.sayHello(name,
                                     surname);
    }

    @GetMapping("/hello5/{name}")
    public String hello5(@PathVariable("name") String name,
                         @RequestParam("surname") String surname) {
        return "5 " + hello.sayHello(name,
                                     surname);
    }

    @PostMapping("/hello6")
    public String hello6(@RequestBody Person personParam){
        // return "Hello 6 " + (personParam == null ? "null" : personParam.toString());
        return "Hello 6 " + personParam;
    }

}
