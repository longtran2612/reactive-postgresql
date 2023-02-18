package com.example.reactivepostgresql.router;

import com.example.reactivepostgresql.handle.UserHandle;
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
    public RouterFunction<ServerResponse> userRoute(UserHandle userHandle){
        return route()
                .nest(path("/user"), builder -> builder
                        .GET("/{id}", userHandle::getById)
                        .GET("/all", userHandle::getAll)
                        .POST("", userHandle::create)
                        .PUT("/{id}", userHandle::update)
                        .DELETE("/{id}", userHandle::deleteById)
                ).build();
    }
}
