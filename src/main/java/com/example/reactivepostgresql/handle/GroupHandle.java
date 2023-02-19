package com.example.reactivepostgresql.handle;

import com.example.reactivepostgresql.base.BaseService;
import com.example.reactivepostgresql.model.domain.Group;
import com.example.reactivepostgresql.model.dto.request.group.CreateGroupRequest;
import com.example.reactivepostgresql.model.dto.request.group.UpdateGroupRequest;
import com.example.reactivepostgresql.model.dto.request.user.CreateUserRequest;
import com.example.reactivepostgresql.model.dto.request.user.UpdateUserRequest;
import com.example.reactivepostgresql.repository.GroupRepository;
import com.example.reactivepostgresql.service.GroupService;
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
public class GroupHandle {

    private final GroupService groupService;


    public Mono<ServerResponse> getById(ServerRequest request){
        return ServerResponse.ok().body(groupService.getById(request.pathVariable("id")), Group.class);
    }
    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok().body(groupService.getAll(), Group.class);
    }

    public Mono<ServerResponse> create(ServerRequest request){
        var createGroupRequest = request.bodyToMono(CreateGroupRequest.class);
        return ServerResponse.ok().body(createGroupRequest.flatMap(groupService::create), Group.class);
    }
    public Mono<ServerResponse> update(ServerRequest request)  {
        var id = request.pathVariable("id");
        var updateRequest = request.bodyToMono(UpdateGroupRequest.class);
        return updateRequest.flatMap(update -> groupService.update(id, update))
                .flatMap(group -> ServerResponse.ok().body(Mono.just(group), Group.class));
    }
    public Mono<ServerResponse> deleteById(ServerRequest request){
        return groupService.deleteById(request.pathVariable("id"))
                .then(ServerResponse.ok().build());
    }

}
