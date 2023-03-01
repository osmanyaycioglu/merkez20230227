package com.merkez.training.spring.firstspring.person.rest;

import com.merkez.training.spring.firstspring.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @PostMapping("/add")
    public String add(@RequestBody Person personParam){
        return "OK";
    }

    @PostMapping("/addx")
    public String addX(@RequestBody Person personParam){
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("pid") Long personId){
        return "OK";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam("pid") Long personId){
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("pid") Long personId){
        return "OK";
    }

}
