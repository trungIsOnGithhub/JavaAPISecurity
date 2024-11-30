package com.nvtrung.controller;

// import org.json.JSONObject;

// import com.lambdaworks.crypto.SCryptUtil;
import com.lambdaworks.crypto.*;
import org.json.*;
import spark.*;

import com.nvtrung.datasource.GenericRepository;

public class UserController {
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

        if (!username.matches(this.USERNAME_PATTERN)) {
            throw new IllegalArgumentException("invalid username");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException(
                    "password must be at least 8 characters");
        }

        var hashPsswd = SCryptUtil.scrypt(password, 32768, 8, 1);

        repo.addUser(username, hashPsswd;)

        response.status(201);
        response.header("Location", "/users/" + username);

        return new JSONObject().put("username", username);
    }
}
