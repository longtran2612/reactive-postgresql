package com.example.reactivepostgresql.handle;

import com.example.reactivepostgresql.base.BaseService;
import com.example.reactivepostgresql.model.domain.Group;
import com.example.reactivepostgresql.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
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
public class GroupService extends BaseService {

    private final GroupRepository groupRepository;


    public Mono<ServerResponse> getById(ServerRequest request){
        return ServerResponse.ok().body(groupRepository.findById(request.pathVariable("id")), Group.class);
    }
    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok().body(groupRepository.findAll(), Group.class);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<ServerResponse> create(ServerRequest request){
        return request.bodyToMono(Group.class)
                .flatMap(groupRepository::save)
                .flatMap(group -> ServerResponse.ok().body(Mono.just(group), Group.class));
    }
}
