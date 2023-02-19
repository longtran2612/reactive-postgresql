package com.example.reactivepostgresql.service;

import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.model.dto.request.user.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SequenceValueServiceTest {

    @Autowired
    private SequenceValueService sequenceValueService;

    @Autowired
    private UserService userService;

    @Test
    void getSequence() {
       var  sequence =  sequenceValueService.getSequence(User.class);
//        StepVerifier.create(sequence).expectNextMatches(x->x.equals("234")).verifyComplete();

//        var user = userService.create(CreateUserRequest.builder().age(123).name("13123").build());
        System.out.println(sequence.block());
    }

}