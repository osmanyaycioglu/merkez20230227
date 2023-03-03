package com.merkez.training.spring.firstspring.person.rest;

import com.merkez.training.spring.firstspring.person.rest.mappers.IPersonMapper;
import com.merkez.training.spring.firstspring.person.rest.models.Person;
import com.merkez.training.spring.firstspring.person.services.PersonProvisionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    private PersonProvisionService personProvisionService;

    @Autowired
    public PersonProvisionController(PersonProvisionService personProvisionServiceParam) {
        personProvisionService = personProvisionServiceParam;
    }

    @Operation(summary = "yeni kişi ekleme",description = "sisteme yeni kişi eklemek için kullanılır...")
    @PostMapping("/add")
    public String add(@Valid @RequestBody Person personParam){
        if (personParam.getFirstName().contains("abc")){
            throw new IllegalArgumentException("abc barıdıramaz");
        }
        personProvisionService.add(IPersonMapper.mapper.toPersonDTO(personParam));
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("pid") Long personId){
        personProvisionService.deactivate(personId);
        return "OK";
    }

    @GetMapping("/activate")
    public String activate(@RequestParam("pid") Long personId){
        personProvisionService.activate(personId);
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("pid") Long personId){
        personProvisionService.suspend(personId);
        return "OK";
    }

}
