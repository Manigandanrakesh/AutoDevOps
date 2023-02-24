package com.auto.devops.integration.service;

import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractCommandCenterHandler<T extends ServerResponse>
        implements HandlerFunction<T> {
    public Flux<T> convertMonoToFlux(Mono<T> mono){
        return mono.flux();
    }
}
