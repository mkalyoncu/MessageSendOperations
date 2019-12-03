package com.prisync.user;

public class User {

    private String name;
    private UserId user_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserId getUser_id() {
        return user_id;
    }

    public void setUser_id(UserId user_id) {
        this.user_id = user_id;
    }
}
