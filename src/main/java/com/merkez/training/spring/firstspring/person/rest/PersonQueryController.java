package com.merkez.training.spring.firstspring.person.rest;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @GetMapping("/get/one")
    public Person getOne(@RequestParam("pid") Long personId){
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<Person> getByName(@RequestParam("surname") String surname){
        return null;
    }

    @GetMapping("/get/all")
    public List<Person> getAll(){
        return null;
    }

}
