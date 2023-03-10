package com.example.reactivepostgresql.model.domain;

import com.example.reactivepostgresql.base.BaseModel;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;


/**
 * 1:41 PM 18-Feb-23
 * Long Tran
 */

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class User extends BaseModel {


    private String name;


    private int age;
}
