package com.example.reactivepostgresql.controller;

import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.model.dto.request.user.CreateUserRequest;
import com.example.reactivepostgresql.model.dto.request.user.UpdateUserRequest;
import com.example.reactivepostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * 12:55 PM 19-Feb-23
 * Long Tran
 */
@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-by-id/{id}")
    private Mono<?> getById(@PathVariable String id) {
        return userService.getById(id);
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<?> create(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Mono<?> update(@PathVariable String id, @RequestBody UpdateUserRequest request) {
        return userService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Mono<?> deleteById(@PathVariable String id) {
        return userService.deleteById(id);
    }
}
