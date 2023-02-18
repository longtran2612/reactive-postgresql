package com.example.reactivepostgresql.repository;

import com.example.reactivepostgresql.model.domain.SequenceValue;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * 9:52 PM 18-Feb-23
 * Long Tran
 */

public interface SequenceValueRepository extends R2dbcRepository<SequenceValue, String> {
}
