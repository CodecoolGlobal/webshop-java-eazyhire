package com.codecool.shop.model;

public class User {

    private int id;
    private String name;
    private String password;
    private String email;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
