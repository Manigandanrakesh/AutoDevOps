package com.auto.devops.integration.service.responseimpl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class EntityResponseImpl implements EntityResponse<JSONPObject> {
    @Override
    public JSONPObject entity() {
        return null;
    }

    @Override
    public BodyInserter<JSONPObject, ? super ServerHttpResponse> inserter() {
        return null;
    }

    @Override
    public HttpStatus statusCode() {
        return null;
    }

    @Override
    public HttpHeaders headers() {
        return null;
    }

    @Override
    public MultiValueMap<String, ResponseCookie> cookies() {
        return null;
    }

    @Override
    public Mono<Void> writeTo(ServerWebExchange exchange, Context context) {
        return null;
    }
}
