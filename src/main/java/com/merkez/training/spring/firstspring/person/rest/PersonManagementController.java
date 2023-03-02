package com.merkez.training.spring.firstspring.person.rest;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonManagementController {

    @PostMapping("/update")
    public String update(Person personParam){
        return "OK";
    }

}
