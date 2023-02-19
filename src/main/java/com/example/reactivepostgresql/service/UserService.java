package com.example.reactivepostgresql.service;

import com.example.reactivepostgresql.base.BaseService;
import com.example.reactivepostgresql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 11:55 AM 19-Feb-23
 * Long Tran
 */
@Service
@RequiredArgsConstructor
public class UserService extends BaseService {
    private final UserRepository userRepository;



}
