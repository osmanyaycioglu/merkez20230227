package com.merkez.training.spring.firstspring.di.configuration;

import com.merkez.training.spring.firstspring.di.HelloEng;
import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("english")
@Configuration
public class EnglishConfiguration {

    @Bean("helloDefault")
    public IHello helloBean() {
        return new HelloEng();
    }

}


