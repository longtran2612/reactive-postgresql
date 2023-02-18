package com.example.reactivepostgresql.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 9:08 PM 18-Feb-23
 * Long Tran
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("groups")
public class Group {
    @Id
    private long id;
    private String name;

}
