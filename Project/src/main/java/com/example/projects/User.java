package com.example.projects;

public class User {
     private String firstName, surName, login,password, gender;
    public User(String firstName, String surName, String login,String password, String gender) {
        this.firstName = firstName;
        this.surName = surName;
        this.login = login;
        this.password = password;
        this.gender = gender;
    }

    public User() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passText) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
