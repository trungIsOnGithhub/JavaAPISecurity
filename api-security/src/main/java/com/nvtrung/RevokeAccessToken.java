package com.manning.apisecurityinaction;

import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

import static java.nio.charset.StandardCharsets;

public class RevokeAccessToken {
    public static void main(String...args) throws Exception {

        if (args.length != 3) {
            throw new IllegalArgumentException("Syntax: RevokeAccessToken [clientId] [clientSecret] [token]");
        }

        var clientId = args[0];
        var clientSecret = args[1];
        var token = args[2];

        var credentials = URLEncoder.encode(clientId, StandardCharsets.UTF_8) +
                            ":" + URLEncoder.encode(clientSecret, StandardCharsets.UTF_8);

        var authorization = "Basic " + Base64.getEncoder().encodeToString(
            credentials.getBytes(StandardCharsets.UTF_8)
        );

        var httpClient = HttpClient.newHttpClient();
        var form = "token=" + URLEncoder.encode(token, StandardCharsets.UTF_8) + "&token_type_hint=access_token";

        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://as.example.com"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", authorization)
                .POST(HttpRequest.BodyPublishers.ofString(form))
                .build();

        httpClient.send(httpRequest, BodyHandlers.discarding());
    }
}