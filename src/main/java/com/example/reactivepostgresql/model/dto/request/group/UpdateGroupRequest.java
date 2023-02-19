package com.example.reactivepostgresql.model.dto.request.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String name;
}
