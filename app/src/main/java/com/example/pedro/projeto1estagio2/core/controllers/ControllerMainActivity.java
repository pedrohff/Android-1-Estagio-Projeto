package com.example.pedro.projeto1estagio2.core.controllers;

public class ControllerMainActivity {
    private static ControllerMainActivity instance = null;

    private String login;
    private String email;
    private String phone;
    private Boolean showEmail = false;
    private Boolean showFriends = false;

    private ControllerMainActivity(){}

    public static ControllerMainActivity getInstance(){
        if (instance == null){
            instance = new ControllerMainActivity();
        }
        return instance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getShowEmail() {
        return showEmail;
    }

    public void setShowEmail(Boolean showEmail) {
        this.showEmail = showEmail;
    }

    public Boolean getShowFriends() {
        return showFriends;
    }

    public void setShowFriends(Boolean showFriends) {
        this.showFriends = showFriends;
    }
}
