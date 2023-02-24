package com.auto.devops.integration.handlers;

import com.auto.devops.integration.constants.CommandCenterConstants;
import com.auto.devops.integration.service.impl.CommandCenterHandlerImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class CommandCenterHandlers {

    public CommandCenterHandlers() {
       RouterFunction<ServerResponse> routerFunction=
               RouterFunctions.route(POST("/autocmd-executor")
                .and(RequestPredicates.accept(APPLICATION_JSON)), new CommandCenterHandlerImpl());
     routerFunction.accept(new CmdVisitor(CommandCenterConstants.
             BaseLookUpConstants.getNullInstance()));
    }

  static class CmdVisitor implements RouterFunctions.Visitor{

        private final RouterFunctions.Visitor visitor;
        public CmdVisitor(RouterFunctions.Visitor visitor){
           this.visitor=visitor;
        }

        @Override
        public void startNested(RequestPredicate predicate) {
            if(Objects.isNull(this.visitor)) return;
            this.visitor.startNested(predicate);
        }

        @Override
        public void endNested(RequestPredicate predicate) {
            if(Objects.isNull(this.visitor)) return;
            this.visitor.endNested(predicate);
        }

        @Override
        public void route(RequestPredicate predicate, HandlerFunction<?> handlerFunction) {
            if(Objects.isNull(this.visitor)) return;
            this.visitor.route(predicate,handlerFunction);
        }

        @Override
        public void resources(Function<ServerRequest, Mono<Resource>> lookupFunction) {
            if(Objects.isNull(this.visitor)) return;
            this.visitor.resources(lookupFunction);
        }

        @Override
        public void unknown(RouterFunction<?> routerFunction) {
            if(Objects.isNull(this.visitor)) return;
            this.visitor.unknown(routerFunction);
        }
    }
}
