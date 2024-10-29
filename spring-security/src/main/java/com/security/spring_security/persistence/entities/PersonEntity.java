package com.security.spring_security.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    private Long id;
    private String name;
    private String lastName;
    private Double balance;

}
