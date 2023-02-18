package com.example.reactivepostgresql.handle;

import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.model.dto.request.UpdateUserRequest;
import com.example.reactivepostgresql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

/**
 * 2:04 PM 18-Feb-23
 * Long Tran
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserHandle {
    private final UserRepository userRepository;

    private final R2dbcEntityTemplate r2dbcEntityTemplate;


    public Mono<ServerResponse> getById(ServerRequest request){
        return ServerResponse.ok().body(userRepository.findById(request.pathVariable("id")), User.class);
    }
    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok().body(userRepository.findAll(), User.class);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<ServerResponse> create(ServerRequest request){
        return request.bodyToMono(User.class)
                .flatMap(r2dbcEntityTemplate::insert)
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class));
    }
    @Transactional(rollbackFor = Exception.class)
    public Mono<ServerResponse> update(ServerRequest request)  {
        var id = request.pathVariable("id");
        var updateRequest = request.bodyToMono(UpdateUserRequest.class);
        return ServerResponse.ok().body(userRepository.findById(id)
                .map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optional -> {
                    if (optional.isPresent()) {
                        var user = optional.get();
                        return updateRequest.map(updateUserRequest -> {
                            user.setName(updateUserRequest.getName());
                            user.setAge(updateUserRequest.getAge());
                            return user;
                        }).flatMap(userRepository::save);
                    } else {
                        return Mono.empty();
                    }
                }), User.class);
    }
    public Mono<ServerResponse> deleteById(ServerRequest request){
        return userRepository.deleteById(request.pathVariable("id"))
                .then(ServerResponse.ok().build());
    }

}
