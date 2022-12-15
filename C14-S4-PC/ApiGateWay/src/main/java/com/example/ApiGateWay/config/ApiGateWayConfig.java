package com.example.ApiGateWay.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class ApiGateWayConfig {

    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){

        return builder.routes().
                route(p->p.path("/api/v1/**").
                                                    uri("http://localhost:8082/")).
                route(p->p.path("/api/v2/**").
                                                    uri("http://localhost:8071/"))
                .build();




    }

}

