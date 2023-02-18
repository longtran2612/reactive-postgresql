package com.example.reactivepostgresql.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


/**
 * 1:41 PM 18-Feb-23
 * Long Tran
 */

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class User {

    @Id
    @Column("id")
    private String id;

    private String name;

    private int age;
}
