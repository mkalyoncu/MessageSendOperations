package com.prisync.user;

public class UserId {

    private String hash;
    private int user_id;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
