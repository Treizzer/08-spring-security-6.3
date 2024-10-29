package com.security.spring_security.presentations.controllers;

import java.util.List;

import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.spring_security.persistence.entities.PersonEntity;
import com.security.spring_security.services.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {

    private final PersonService personService;
    private final CompromisedPasswordChecker passwordChecker;

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

        // Web: https://haveibeenpwned.com/Passwords
        CompromisedPasswordDecision decision = this.passwordChecker.check(password);

        if (decision.isCompromised()) {
            throw new IllegalArgumentException("Compromised Password");
        }

        return String.format("User %s registered successfully", username);
    }

}
