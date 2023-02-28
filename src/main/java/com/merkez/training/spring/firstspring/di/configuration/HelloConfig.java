package com.merkez.training.spring.firstspring.di.configuration;

import a.b.c.TestBean;
import a.b.c.TestConfig;
import com.merkez.training.spring.firstspring.di.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@Configuration
@Import(TestConfig.class)
public class HelloConfig {

    @Bean
    public IHello createHello() {
        return new HelloTr();
    }

    @Bean("helloTe")
    @Qualifier("helloDynamic")
    public IHello helloDeneme(@Value("${app.xyz.language}") String language) {
        switch (language){
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            case "eng":
            default:
                return new HelloEng();
        }
    }

    @Bean("helloTe2")
    public IHello helloDeneme2(Environment environmentParam) {
        String language = environmentParam.getProperty("app.xyz.language");
        switch (language){
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            case "eng":
            default:
                return new HelloEng();
        }
    }

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }
}
