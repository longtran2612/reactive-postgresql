package com.example.reactivepostgresql.handle;

import com.example.reactivepostgresql.base.BaseService;
import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.model.dto.request.user.CreateUserRequest;
import com.example.reactivepostgresql.model.dto.request.user.UpdateUserRequest;
import com.example.reactivepostgresql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * 2:04 PM 18-Feb-23
 * Long Tran
 */
@Component
@RequiredArgsConstructor
public class UserHandle {
    private final UserService userService;


    public Mono<ServerResponse> getById(ServerRequest request){
        return ServerResponse.ok().body(userService.getById(request.pathVariable("id")), User.class);
    }
    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok().body(userService.getAll(), User.class);
    }

    public Mono<ServerResponse> create(ServerRequest request){
        var createUserRequest = request.bodyToMono(CreateUserRequest.class);
        return ServerResponse.ok().body(createUserRequest.flatMap(userService::create), User.class);
    }
    public Mono<ServerResponse> update(ServerRequest request)  {
        var id = request.pathVariable("id");
        var updateRequest = request.bodyToMono(UpdateUserRequest.class);
        return updateRequest.flatMap(update -> userService.update(id, update))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class));
    }
    public Mono<ServerResponse> deleteById(ServerRequest request){
        return userService.deleteById(request.pathVariable("id"))
                .then(ServerResponse.ok().build());
    }

}
