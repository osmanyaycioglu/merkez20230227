package com.merkez.training.spring.firstspring;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

// @SpringBootApplication(scanBasePackages = {"com.merkez.training.spring.firstspring","a.b.c"})
@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class FirstSpringApplication {



    public static void main(String[] args) {
//        Class<FirstSpringApplication> firstSpringApplicationClass = FirstSpringApplication.class;
//        SpringBootApplication annotation = firstSpringApplicationClass.getAnnotation(SpringBootApplication.class);
//        String[] strings = annotation.scanBasePackages();
        ConfigurableApplicationContext context = SpringApplication.run(FirstSpringApplication.class,
                                                                   args);
        Person person = new Person();
        person.setUsername("user3");
        person.setFirstName("osman");
        person.setLastName("yaycıoğlu");
        person.setAge(53);

        PersonManager personManager = context.getBean(PersonManager.class);
        personManager.addPerson(person);

        System.out.println("hello");

    }

}
