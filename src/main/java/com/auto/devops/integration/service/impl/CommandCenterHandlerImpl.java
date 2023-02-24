package com.auto.devops.integration.service.impl;

import com.auto.devops.integration.service.AbstractCommandCenterHandler;
import com.auto.devops.integration.service.responseimpl.EntityResponseImpl;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class CommandCenterHandlerImpl extends AbstractCommandCenterHandler<ServerResponse> {
    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        ServerResponse serverResponse=  request.body((inputMessage, context) -> {
          inputMessage.getBody();
          return new EntityResponseImpl();
        });
        return Mono.just(serverResponse);
    }
}
