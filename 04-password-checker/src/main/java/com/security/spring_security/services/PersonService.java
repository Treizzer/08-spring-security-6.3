package com.security.spring_security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.security.spring_security.persistence.entities.PersonEntity;

@Service
public class PersonService {

    public Optional<PersonEntity> findById(Long id) {
        var personOptional = Optional.of(new PersonEntity(1L, "Hugo", "Santana", 10000.0));

        return personOptional;
    }

    public List<PersonEntity> findAll() {
        return List.of(
                new PersonEntity(1L, "Hugo", "Santana", 10000.0),
                new PersonEntity(2L, "Paco", "Ramirez", 20000.0),
                new PersonEntity(3L, "Luis", "Vega", 150000.0));
    }

}
