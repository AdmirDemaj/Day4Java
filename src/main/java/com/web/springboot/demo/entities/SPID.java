package com.web.springboot.demo.entities;

import java.util.Date;

public class SPID extends Base {

    public String description;
    private User user;
    Status status = Status.PENDING;


    public SPID() {

    }


    public SPID(int id, Date modifiedAt , Date createdAt, String description, Status status, User user) {
        super(id, modifiedAt ,createdAt);
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

