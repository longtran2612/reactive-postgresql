package com.example.reactivepostgresql.repository;

import com.example.reactivepostgresql.model.domain.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * 1:54 PM 18-Feb-23
 * Long Tran
 */
public interface UserRepository extends R2dbcRepository<User, String> {
}
