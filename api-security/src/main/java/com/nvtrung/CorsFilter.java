package com.nvtrung;

import spark.*;
import java.util.Set;
import static spark.Spark.halt;

class CorsFilter implements Filter {
    private final Set<String> allowedOrigins;

    CorsFilter(Set<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    private boolean isPreflightRequest(Request request) {
        return request.requestMethod().equals("OPTIONS")
                && request.headers().contains("Access-Control-Request-Method");
    }

    @Override
    public void handle(Request request, Response response) {
        var origin = request.headers("Origin");

        if (origin != null && allowedOrigins.contains(origin)) {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Vary", "Origin");
        }

        if (isPreflightRequest(request)) {
            if (origin == null || !allowedOrigins.contains(origin)) {
                halt(403);
            }

            response.header("Access-Control-Allow-Headers",
                    "Content-Type, Authorization");
            response.header("Access-Control-Allow-Methods",
                    "GET, POST, DELETE, PUT");
            halt(204);
        }
    }
}
