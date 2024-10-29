package com.security.spring_security.configurations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // To use methods
@PreAuthorize("hasAnyRole('{value}')") // Whos will get access?
public @interface IsEmployee {

    String[] value();

}
