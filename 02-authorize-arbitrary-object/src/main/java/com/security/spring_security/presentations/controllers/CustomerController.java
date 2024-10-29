package com.security.spring_security.presentations.controllers;

import java.util.List;

import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring_security.persistence.entities.PersonEntity;
import com.security.spring_security.services.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@AuthorizeReturnObject
public class CustomerController {

    private final PersonService personService;

    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return "Hello World Admin";
    }

    @GetMapping("/user")
    public String sayHelloUser() {
        return "Hello World User";
    }

    @GetMapping("/invited")
    public String sayHelloInvited() {
        return "Hello World Invited";
    }

    // Also this works at class level, check the top
    @GetMapping("/find")
    // @AuthorizeReturnObject // Notice the "PersonService"
    public PersonEntity findById() {
        return this.personService.findById().orElseThrow();
    }

    @GetMapping("/findAll")
    // @AuthorizeReturnObject
    public List<PersonEntity> findAll() {
        return this.personService.findAll();
    }

    @GetMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        return "";
    }

}
