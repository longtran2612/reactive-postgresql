package com.example.reactivepostgresql.handle;

import com.example.reactivepostgresql.model.domain.Group;
import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 9:10 PM 18-Feb-23
 * Long Tran
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class GroupHandle {

    private final GroupRepository groupRepository;

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    public Mono<ServerResponse> getById(ServerRequest request){
        return ServerResponse.ok().body(groupRepository.findById(Long.valueOf(request.pathVariable("id"))), Group.class);
    }
    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok().body(groupRepository.findAll(), Group.class);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<ServerResponse> create(ServerRequest request){
        return request.bodyToMono(Group.class)
                .flatMap(r2dbcEntityTemplate::insert)
                .flatMap(group -> ServerResponse.ok().body(Mono.just(group), Group.class));
    }
}
