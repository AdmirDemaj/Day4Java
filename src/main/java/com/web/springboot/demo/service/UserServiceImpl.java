package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.Type;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User with id: " + userId + " doesnt exist"));
    }

    @Override
    public User editUserById(Long userId, String name, String surname, String email) {
       Optional<User> user = Optional.ofNullable
               (userRepository.findById
                       (userId).orElseThrow(() ->
                       new IllegalArgumentException
                               ("User with id: " + userId + " doesnt exist")));

      user.get().setName(name);
      user.get().setSurname(surname);
      user.get().setEmail(email);
      return userRepository.save(user.get());

    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
}
