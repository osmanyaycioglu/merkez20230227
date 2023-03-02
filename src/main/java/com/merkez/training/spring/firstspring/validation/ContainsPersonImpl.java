package com.merkez.training.spring.firstspring.validation;

import com.merkez.training.spring.firstspring.person.rest.models.Person;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ContainsPersonImpl implements ConstraintValidator<ContainsStr,Person> {

    private ContainsStr constraintAnnotation;

    @Override
    public void initialize(ContainsStr constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Person personParam,
                           ConstraintValidatorContext context) {
        if (!check(personParam.getFirstName())){
            context.disableDefaultConstraintViolation();
            ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder = context.buildConstraintViolationWithTemplate(
                    "firstName "
                    + Arrays.toString(constraintAnnotation.value())
                    + " içinde barındırmamalı. Fakat " + personParam.getFirstName() + " bunu bozuyor.");
            constraintViolationBuilder.addConstraintViolation();
            return false;
        }
        if (!check(personParam.getLastName())){
            return false;
        }
        if (!check(personParam.getUsername())){
            return false;
        }
        if (!check(personParam.getPassword())){
            return false;
        }
        return true;
    }
    private boolean check(String str){
        String[] containsStrs = constraintAnnotation.value();
        for (String containsStr : containsStrs) {
            if (str.contains(containsStr)){
                return false;
            }
        }
        return true;

    }
}
