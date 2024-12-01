package com.nvtrung.controller;

import java.lang.IllegalArgumentException;
import java.nio.charset.StandardCharsets;

// import com.lambdaworks.crypto.SCryptUtil;
import com.lambdaworks.crypto.*;
import org.json.*;
import spark.*;

import com.nvtrung.datasource.GenericRepository;

public class UserController {
    private static final List<String> ROLES = {"owner", "moderator", "member", "observer"};
    GenericRepository repo;

    public void addRepo(GenericRepository repo) {
        this.repo = repo;
    }

    public JSONObject createOne(Request request, Response response) {
        var json = new JSONObject(request.body());

        var spaceName = json.getString("name");
        if (spaceName.length() > 128) {
          throw new IllegalArgumentException("space name too long");
        }

        var owner = json.getString("owner");
        if ( !owner.matches(UserController.USERNAME_REGEX_PATTERN) ) {
          throw new IllegalArgumentException("invalid username");
        }

        var subject = request.attribute("subject");
        if ( !owner.equals(subject) ) {
          throw new IllegalArgumentException("Owner not match subject info");
        }

        repo.addSpace(spaceName, owner);

        // Grant all roles to the owner
        var roleExpr = String.join("|", this.ROLES);
        repo.addSpaceRole(spaceName, owner, roleExpr);
    
        response.status(201);
        response.header("Location", "/spaces/" + spaceId);

        return new JSONObject().put("name", spaceName)
                    .put("uri", "/spaces/" + spaceId);
    }
}