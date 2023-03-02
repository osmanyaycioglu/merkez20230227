package com.merkez.training.spring.firstspring.person.services;

import com.merkez.training.spring.firstspring.person.data.PersonDataService;
import com.merkez.training.spring.firstspring.person.services.models.EPersonStatus;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonProvisionService {

//    private List<String>          strings      = new Vector<>();
//    private Map<String,PersonDTO> personDTOMap = new ConcurrentHashMap<>();
//    private AtomicInteger         counter      = new AtomicInteger();

    private PersonDataService personDataService;

    @Autowired
    public PersonProvisionService(PersonDataService personDataServiceParam) {
        personDataService = personDataServiceParam;
    }

    public void add(PersonDTO personDTOParam) {
        personDataService.insert(personDTOParam);
    }

    public void activate(Long personId) {
        personDataService.updateStatus(personId,
                                       EPersonStatus.ACTIVE);
    }

    public void deactivate(Long personId) {
        personDataService.updateStatus(personId,
                                       EPersonStatus.PASSIVE);
    }

    public void suspend(Long personId) {
        personDataService.updateStatus(personId,
                                       EPersonStatus.SUSPENDED);
    }

}
