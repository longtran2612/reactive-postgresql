package com.example.reactivepostgresql.router;

import com.example.reactivepostgresql.handle.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
/**
 * 2:07 PM 18-Feb-23
 * Long Tran
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> userRoute(UserService userHandle){
        return route()
                .nest(path("/user"), builder -> builder
                        .GET("/get-by-id/{id}", userHandle::getById)
                        .GET("/get-all", userHandle::getAll)
                        .POST("/create", userHandle::create)
                        .PUT("/update/{id}", userHandle::update)
                        .DELETE("/delete/{id}", userHandle::deleteById)
                ).build();
    }
}
