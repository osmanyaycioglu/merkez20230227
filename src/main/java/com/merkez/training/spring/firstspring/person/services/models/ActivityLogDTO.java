package com.merkez.training.spring.firstspring.person.services.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder(setterPrefix = "with")
@Entity
public class ActivityLogDTO {
    @Id
    @GeneratedValue
    private Long alId;
    private String activity;
    private String logStr;
}
