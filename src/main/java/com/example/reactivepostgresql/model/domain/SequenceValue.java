package com.example.reactivepostgresql.model.domain;

/**
 * 9:38 PM 18-Feb-23
 * Long Tran
 */

import com.example.reactivepostgresql.base.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table("sequence_value")
public class SequenceValue extends BaseModel {

    private int seqId;


}
