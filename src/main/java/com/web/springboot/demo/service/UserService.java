package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    //Create new User
    public User createUser(User user){
        User savedUser = new User(
                user.getId(),
                user.getCreatedAt(),
                user.getModifiedAt(),
                user.getName(),
                user.getUsername(),
                user.getSurname());
        return savedUser;
    }


    //Editing User
    public static void editUser(User user, int id, Date createdAt, Date modifiedAt, String name, String username, String surname) {

        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setCreatedAt(createdAt);
        user.setModifiedAt(modifiedAt);
    };




    }


