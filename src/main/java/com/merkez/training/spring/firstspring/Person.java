package com.merkez.training.spring.firstspring;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// POJO
// DTO
// @Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String username;
}
