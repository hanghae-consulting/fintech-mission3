package com.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            // Skip authentication for auth service paths
            if (request.getURI().getPath().startsWith("/auth/")) {
                return chain.filter(exchange);
            }

            log.debug("AuthenticationFilter: Validating session for path: {}", request.getURI().getPath());

            // Check for session authentication
            return exchange.getSession()
                    .flatMap(session -> {
                        // Check if user is authenticated
                        if (session.getAttributes().containsKey("AUTHENTICATED_USER")) {
                            log.debug("AuthenticationFilter: User is authenticated");
                            return chain.filter(exchange);
                        } else {
                            log.debug("AuthenticationFilter: User is not authenticated");
                            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            return exchange.getResponse().setComplete();
                        }
                    });
        };
    }

    public static class Config {
        // Configuration properties if needed
    }
}
