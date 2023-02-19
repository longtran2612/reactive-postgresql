package com.example.reactivepostgresql.service;

import com.example.reactivepostgresql.base.BaseService;
import com.example.reactivepostgresql.model.domain.User;
import com.example.reactivepostgresql.model.dto.request.user.CreateUserRequest;
import com.example.reactivepostgresql.model.dto.request.user.UpdateUserRequest;
import com.example.reactivepostgresql.repository.UserRepository;
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
public class UserService extends BaseService {
    private final UserRepository userRepository;

    public Mono<User> getById(String id) {
        return userRepository.findById(id);
    }

    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<User> create(CreateUserRequest request) {
        var user = MappingUtils.mapObject(request, User.class);
//        user.setId(sequenceValueService.getSequence(User.class));
//       return sequenceValueService.getSequence(User.class).flatMap(id -> {
////            user.setId(id);
//            return userRepository.save(user);
//        }).log();
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<User> update(String id, UpdateUserRequest request) {
        return userRepository.findById(id)
                .map(user -> {
                    return MappingUtils.mapObject(request, user);
                }).flatMap(userRepository::save);
    }

    @Transactional(rollbackFor = Exception.class)
    public Mono<Void> deleteById(String id) {
        return userRepository.deleteById(id);
    }


}
