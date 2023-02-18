package com.example.reactivepostgresql.router;

import com.example.reactivepostgresql.handle.GroupHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 9:13 PM 18-Feb-23
 * Long Tran
 */
@Configuration
public class GroupRouter {

    @Bean
    public RouterFunction<ServerResponse> groupRoute(GroupHandle groupHandle) {
        return route().
                nest(path("/group"), builder -> builder
                        .GET("/get-by-id/{id}", groupHandle::getById)
                        .POST("/create", groupHandle::create)
                        .GET("/get-all", groupHandle::getAll)
                ).build();
    }
}
