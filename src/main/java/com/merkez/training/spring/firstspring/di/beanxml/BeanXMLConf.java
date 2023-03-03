package com.merkez.training.spring.firstspring.di.beanxml;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:bean.xml")
public class BeanXMLConf {
}
