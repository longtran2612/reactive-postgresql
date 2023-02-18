package com.example.reactivepostgresql.base;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * 9:40 PM 18-Feb-23
 * Long Tran
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    @Id
    private String id;

    private LocalDate createdDate;

    private LocalDate updatedDate;

    private String createdBy;

    private String updatedBy;
}
