package com.merkez.training.spring.firstspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithImpl implements ConstraintValidator<StartWith,String> {
    private StartWith anno;

    @Override
    public void initialize(StartWith constraintAnnotation) {
        anno = constraintAnnotation;
    }

    @Override
    public boolean isValid(String data,
                           ConstraintValidatorContext context) {
        String[] values = anno.xyz();
        int count = anno.count();
        for (String s : values) {
            if (data.startsWith(s)){
                return true;
            }
        }
        return false;
    }
}
