package com.example.reactivepostgresql.model.dto.request.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;

/**
 * 2:10 PM 18-Feb-23
 * Long Tran
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest {

    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Name must be alphanumeric")
    private String name;

    @Positive(message = "Age must be positive")
    @Max(value = 150, message = "Age must be less than 150")
    private Integer age;

}
