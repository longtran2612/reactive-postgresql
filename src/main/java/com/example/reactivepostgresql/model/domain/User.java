package com.example.reactivepostgresql.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;


/**
 * 1:41 PM 18-Feb-23
 * Long Tran
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table("users")
public class User {

    @Id
    private String id;

    private String name;

    private int age;
}
