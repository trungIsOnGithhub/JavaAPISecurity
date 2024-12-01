package com.nvtrung.datasource;

import java.util.List;

import com.nvtrung.model.*;

public class GenericRepository {
    List<User> users;
    List<User> spaces;
    List<User> spaceRoles;

    public void addUser(String username, String hashPsswd) {
        var newUsr = new User(username, hashPsswd);
        users.Add(newUsr);
    }

    public User findUser(String usrname) {
        return users.stream(usr -> usrname.equals(usr.usrname))
                    .findAny().orElse(null);
    }

    public void addSpace(String spaceName, String owner) {
        var sp = new Space(spaceName, owner);
        spaces.Add(sp);
    }

    public void addSpaceRole(String spaceName, String user, String roleExpr) {
        var spr = new SpaceRole(spaceName, user, roleExpr);
        spaceRoles.Add(spr);
    }
}