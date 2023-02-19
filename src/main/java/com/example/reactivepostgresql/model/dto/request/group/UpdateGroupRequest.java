package com.example.reactivepostgresql.model.dto.request.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * 12:21 PM 19-Feb-23
 * Long Tran
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateGroupRequest {
    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Name must be alphanumeric")
    private String name;
}
