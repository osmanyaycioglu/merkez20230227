package com.merkez.training.spring.firstspring.person.rest;

import com.merkez.training.spring.firstspring.Person;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody Person personParam){
        if (personParam.getFirstName().contains("abc")){
            throw new IllegalArgumentException("abc barıdıramaz");
        }
        return "OK";
    }

    @PostMapping("/addx")
    public String addX(@RequestBody Person personParam){
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@Max(100) @RequestParam("pid") Long personId){
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
