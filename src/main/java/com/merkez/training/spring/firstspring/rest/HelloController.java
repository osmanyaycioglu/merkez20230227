package com.merkez.training.spring.firstspring.rest;

import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
