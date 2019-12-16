package com.app.secret.entity;

public class TokenUsers{

    private String uuid;

    private String username;

    private String token;

    public TokenUsers(){

    }

    public TokenUsers(String uuid, String username, String token) {
        this.uuid = uuid;
        this.username = username;
        this.token = token;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
