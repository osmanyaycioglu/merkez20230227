package com.merkez.training.spring.firstspring.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//MVC - Model View Controller
// @Controller
// @ResponseBody
@RestController
@RequestMapping("/first")
public class FirstRest {

    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "hello world post";
    }

    @PutMapping("/hello")
    public String hello3() {
        return "hello world put";
    }

    @DeleteMapping("/hello")
    public String hello4() {
        return "hello world delete";
    }

    @PatchMapping("/hello")
    public String hello5() {
        return "hello world patch";
    }

}
