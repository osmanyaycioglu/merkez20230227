package com.merkez.training.spring.firstspring.di.configuration;

import com.merkez.training.spring.firstspring.di.HelloEsp;
import com.merkez.training.spring.firstspring.di.HelloTr;
import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("spanish")
@Configuration
public class SpanishConfiguration {

    @Bean("helloDefault")
    public IHello helloBean() {
        return new HelloEsp();
    }

}


