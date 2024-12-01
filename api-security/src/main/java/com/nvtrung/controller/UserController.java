package com.nvtrung.controller;

import java.lang.IllegalArgumentException;
import java.nio.charset.StandardCharsets;

// import com.lambdaworks.crypto.SCryptUtil;
import com.lambdaworks.crypto.*;
import org.json.*;
import spark.*;

import com.nvtrung.datasource.GenericRepository;

public class UserController {
    private static final String USERNAME_REGEX_PATTERN = "[a-zA-Z][a-zA-Z0-9]{1,29}";
    GenericRepository repo;

    public void addRepo(GenericRepository repo) {
        this.repo = repo;
    }

    // PAGE: 81
    public JSONObject register(Request request, Response response)
    throws Exception {
        var json = new JSONObject(request.body());

        var username = json.getString("username");
        var password = json.getString("password");

        if (!username.matches(this.USERNAME_REGEX_PATTERN)) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }

        var hashPsswd = SCryptUtil.scrypt(password, 32768, 4, 1);

        repo.addUser(username, hashPsswd);

        response.status(201);
        response.header("Location", "/users/" + username);

        return (new JSONObject()).put("username", username);
    }
    public void authenticate(Request request, Response response) {
        var credentials = getCredentials(request);

        if (credentials == null) {
            return;
        }

        var username = credentials[0];
        var password = credentials[1];

        var user = repo.findUser(username);

        if (user.hashPsswd == null || user.hashPsswd.length() < 1) {
            return;
        }

        if (SCryptUtil.check(password, user.hashPsswd)) {
            request.attribute("subject", user.usrname);

            if (user.groupId > 0) {
                request.attribute("groups", groups);   
            }
        }
    }
    String[] getCredentials(Request request) {
        var authSchema = "Basic "
        var offset = authSchema.length();
        var authHeader = request.headers("Authorization");

        if (authHeader == null || !authHeader.startsWith(authSchema)) {
            return null;
        }

        var authKey = authHeader.substring(offset);
        var credentials = new String(
            Base64.getDecoder().decode(authKey),
            StandardCharsets.UTF_8
        );

        var components = credentials.split(":", 2);
        if (components.length != 2) {
            throw new IllegalArgumentException("Invalid auth header");
        }

        var username = components[0];
        if (!username.matches(USERNAME_PATTERN)) {
            throw new IllegalArgumentException("Invalid username");
        }

        return components;
    }

    public void requireAuthentication(Request request, Response response) {
        if (request.attribute("subject") == null) {
            response.header("WWW-Authenticate", "Bearer");
            halt(401);
        }
    }


    public void lookupPermissions(Request request, Response response) {
        requireAuthentication(request, response);

        var spaceId = Long.parseLong(request.params(":spaceId"));
        var username = (String) request.attribute("subject");

        var role = (String) request.attribute("role");
        var perms = findRole(spaceId, username, role);

        request.attribute("perms", perms);
    }
}
