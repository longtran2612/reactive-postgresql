package com.example.reactivepostgresql.model.dto.request.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * 12:12 PM 19-Feb-23
 * Long Tran
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateGroupRequest {
    private String name;

}
