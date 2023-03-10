package com.merkez.training.spring.firstspring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {StartWithImpl.class })
public @interface StartWith {

    String[] xyz();

    int count();

    String message() default "Verilen String {value} ile başlamalı";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
