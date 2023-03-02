package com.merkez.training.spring.firstspring.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Constraint(validatedBy = { ContainsStrImpl.class,ContainsPersonImpl.class})
public @interface ContainsStr {
    String[] value();

    String message() default "{javax.validation.constraints.ContainsStr.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
