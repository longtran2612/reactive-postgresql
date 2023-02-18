package com.example.reactivepostgresql.repository;

import com.example.reactivepostgresql.model.domain.Group;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * 9:10 PM 18-Feb-23
 * Long Tran
 */

public interface GroupRepository extends R2dbcRepository<Group,String> {
}
