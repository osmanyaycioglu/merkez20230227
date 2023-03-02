package com.merkez.training.spring.firstspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;

public class ContainsStrImpl implements ConstraintValidator<ContainsStr,String> {

    private ContainsStr constraintAnnotation;

    @Override
    public void initialize(ContainsStr constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(String str,
                           ConstraintValidatorContext context) {
        String[] containsStrs = constraintAnnotation.value();
        for (String containsStr : containsStrs) {
            if (str.contains(containsStr)){
                return false;
            }
        }
        return true;
    }
}
