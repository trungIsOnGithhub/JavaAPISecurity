package com.nvtrung.datasource;

import java.util.List;

import com.nvtrung.model.*;

public class GenericRepository {
    List<User> users;

    public void addUser() {
        var newUsr = new User(username, hashPsswd);
        users.Add(newUsr);
    }

    public User findUser(String usrname) {
        return users.stream(usr -> usrname.equals(usr.usrname))
                    .findAny().orElse(null);
    }
}