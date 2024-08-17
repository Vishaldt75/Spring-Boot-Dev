package com.example.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstratintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    //Define Default values
    public String value() default "VIS";
    public String message() default "Must start with VIS";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
