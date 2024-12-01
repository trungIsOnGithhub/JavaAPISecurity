package com.nvtrung.model;

public class Decision {
    private boolean permit = true;

    public void deny() {
        permit = false;
    }

    public void permit() {
    }

    boolean isPermitted() {
        return permit;
    }   
}