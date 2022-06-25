package com.web.springboot.demo.service;

import com.web.springboot.demo.exceptions.UserExistsException;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) throws Exception {
        Optional<User> findIfUserExists = userRepository.findById(user.getId());

        if(findIfUserExists.isPresent()){
            throw new UserExistsException("Useri egziston");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(long id) throws Exception{
        return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with id: " + id + " doesnt exist")));
    }

    @Override
    public User editUserById(User user, long id) throws Exception {

if (!(userRepository.findById(id).isPresent())){
    throw new Exception("User with id" + id + "doesnt exist");
}
     user.setId(id);
     return userRepository.save(user);
    }
}
