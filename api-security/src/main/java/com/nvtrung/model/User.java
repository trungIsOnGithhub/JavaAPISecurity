package com.nvtrung.model;

public class User {
    public String usrname;
    public String hashPsswd;
    public int groupId;

    public User(String usrname, String hashPsswd) {
        this.usrname = usrname;
        this.hashPsswd = hashPsswd;
        this.groupId = -1;
    }
}
