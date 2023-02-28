package com.merkez.training.spring.firstspring.di.configuration;

import com.merkez.training.spring.firstspring.di.HelloTr;
import com.merkez.training.spring.firstspring.di.IHello;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("turkish")
@Configuration
public class TurkishConfiguration {

    @Bean("helloDefault")
    @Qualifier("xyzHello")
    public IHello helloBean() {
        return new HelloTr();
    }

}


