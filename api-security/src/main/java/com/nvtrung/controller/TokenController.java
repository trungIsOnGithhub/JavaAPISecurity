package com.nvtrung.controller;

import com.nvtrung.token.*;
import org.json.JSONObject;
import spark.*;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static java.time.Instant.now;

import static spark.Spark.halt;

public class TokenController {
    private static final String DEFAULT_SCOPES =
            "create_space post_message read_message list_messages " +
                    "delete_message add_member";

    private final SecureTokenStore tokenStore;

    public TokenController(SecureTokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    public JSONObject login(Request request, Response response) {
        String subject = request.attribute("subject");
        var expiry = now().plus(10, ChronoUnit.MINUTES);

        var token = new TokenStore.Token(expiry, subject);
        var scope = request.queryParamOrDefault("scope", DEFAULT_SCOPES);
        token.attributes.put("scope", scope);

        var role = request.queryParams("role");
        if (role != null) {
            token.attributes.put("role", role);
        }

        var tokenId = tokenStore.create(request, token);

        response.status(201);
        return new JSONObject()
                .put("token", tokenId);
    }

    public void validateToken(Request request, Response response) {
        var tokenId = request.headers("Authorization");
        if (tokenId == null || !tokenId.startsWith("Bearer ")) {
            return;
        }
        tokenId = tokenId.substring(7);

        tokenStore.read(request, tokenId).ifPresent(token -> {
            if (now().isBefore(token.expiry)) {
                request.attribute("subject", token.username);
                token.attributes.forEach(request::attribute);
            } else {
                response.header("WWW-Authenticate",
                        "Bearer error=\"invalid_token\"," +
                                "error_description=\"Expired\"");
                halt(401);
            }
        });
    }

    public Filter requireScope(String method, String requiredScope) {
        return (request, response) -> {
            if (!method.equalsIgnoreCase(request.requestMethod()))
                return;

            var tokenScope = request.<String>attribute("scope");
            if (tokenScope == null) return;
            if (!Arrays.asList(tokenScope.split(" "))
                    .contains(requiredScope)) {
                response.header("WWW-Authenticate",
                        "Bearer error=\"insufficient_scope\"," +
                                "scope=\"" + requiredScope + "\"");
                halt(403);
            }
        };
    }

    public JSONObject logout(Request request, Response response) {
        var tokenId = request.headers("Authorization");
        if (tokenId == null || !tokenId.startsWith("Bearer ")) {
            throw new IllegalArgumentException("missing token header");
        }
        tokenId = tokenId.substring(7);

        tokenStore.revoke(request, tokenId);

        response.status(200);
        return new JSONObject();
    }
}