package com.example.reactivepostgresql.model.domain;

import com.example.reactivepostgresql.base.BaseModel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 9:08 PM 18-Feb-23
 * Long Tran
 */
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table("groups")
public class Group extends BaseModel {


    private String name;

}
