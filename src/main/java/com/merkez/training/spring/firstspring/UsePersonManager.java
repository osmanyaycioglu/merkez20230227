package com.merkez.training.spring.firstspring;

import com.merkez.training.spring.firstspring.di.configuration.properties.AppProperties;
import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UsePersonManager implements ApplicationRunner {

    private PersonManager personManager;
    // @Value("${app.xyz.language}")
    private String language;
    private AppProperties appProperties;
//    public UsePersonManager() {
//    }

    @Autowired
    public UsePersonManager(PersonManager personManagerParam,
                            @Value("${app.xyz.language}") String languageParam,
                            Environment environmentParam,
                            ApplicationContext contextParam,
                            AppProperties appPropertiesParam) {
        personManager = personManagerParam;
        language = languageParam;
        appProperties = appPropertiesParam;
        Person person = new Person();
        person.setUsername("user2");
        person.setFirstName("Mehmet");
        person.setLastName("alaz");
        person.setAge(33);
        personManager.addPerson(person);
    }

    public void sayHelloToAll() {
        Map<String, Person> personMap = personManager.getPersonMap();
        for (Person value : personMap.values()) {
            System.out.println(language + " Hello " + value.getFirstName() + " " + value.getLastName());
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(appProperties);
        sayHelloToAll();
    }
}
