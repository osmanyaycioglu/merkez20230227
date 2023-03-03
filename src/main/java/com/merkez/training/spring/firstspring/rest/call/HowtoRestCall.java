package com.merkez.training.spring.firstspring.rest.call;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.web.client.RestTemplate;

public class HowtoRestCall {

    public void callRest(){
        RestTemplate restTemplate = new RestTemplate();
        Person forObject = restTemplate.getForObject("http://127.0.0.1/api/v1/person/query/get/one?pid=2",
                                                     Person.class);

    }

}
