package com.web.springboot.demo.entities;


import java.util.Date;

public class User extends Base {

    private String name;
    private String username;

    private String surname;

    public User() {
    }

    public User(int id, Date createdAt, Date modifiedAt, String name, String username, String surname) {
        super(id, createdAt, modifiedAt);
        this.name = name;
        this.username = username;
        this.surname = surname;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
