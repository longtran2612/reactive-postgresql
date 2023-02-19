package com.example.reactivepostgresql.service;

import com.example.reactivepostgresql.base.BaseService;
import com.example.reactivepostgresql.model.domain.Group;
import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.model.dto.request.group.CreateGroupRequest;
import com.example.reactivepostgresql.model.dto.request.group.UpdateGroupRequest;
import com.example.reactivepostgresql.model.dto.request.user.CreateUserRequest;
import com.example.reactivepostgresql.model.dto.request.user.UpdateUserRequest;
import com.example.reactivepostgresql.repository.GroupRepository;
import com.example.reactivepostgresql.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 11:55 AM 19-Feb-23
 * Long Tran
 */
@Service
@RequiredArgsConstructor
public class GroupService extends BaseService {


    private final GroupRepository groupRepository;

    public Mono<Group> getById(String id) {
        return groupRepository.findById(id);
    }

    public Flux<Group> getAll() {
        return groupRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<Group> create(CreateGroupRequest request) {
        var group = MappingUtils.mapObject(request, Group.class);
//        return  sequenceValueService.getSequence(Group.class).flatMap(id -> {
//            group.setId(id);
//            return groupRepository.save(group);
//        });
        return groupRepository.save(group);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<Group> update(String id, UpdateGroupRequest request) {
        return groupRepository.findById(id)
                .map(group -> {
                    return MappingUtils.mapObject(request, group);
                }).flatMap(groupRepository::save);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<Void> deleteById(String id) {
        return groupRepository.deleteById(id);
    }

}
