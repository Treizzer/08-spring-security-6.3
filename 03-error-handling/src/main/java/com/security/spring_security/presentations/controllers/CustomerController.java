package com.security.spring_security.presentations.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring_security.configurations.exceptions.SecurityErrorHandler;
import com.security.spring_security.persistence.entities.PersonEntity;
import com.security.spring_security.services.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
public class CustomerController {

    private final PersonService personService;

    // Also this annotation can be typed in class level
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    // @HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
    public String sayHelloAdmin() {
        return "Hello World Admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    // @HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
    public String sayHelloUser() {
        return "Hello World User";
    }

    @GetMapping("/invited")
    @PreAuthorize("hasRole('INVITED')")
    // @HandleAuthorizationDenied(handlerClass = SecurityErrorHandler.class)
    public String sayHelloInvited() {
        return "Hello World Invited";
    }

    @GetMapping("/{id}")
    public PersonEntity findById(@PathVariable Long id) {
        return this.personService.findById(id).orElseThrow();
    }

    @GetMapping
    public List<PersonEntity> findAll() {
        return this.personService.findAll();
    }

    @GetMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        return "";
    }

}
