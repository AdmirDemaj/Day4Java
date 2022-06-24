package com.web.springboot.demo.service;




import com.web.springboot.demo.entities.Type;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public User addUser(User user);
    public User getUser(Long userId);
    public User editUserById(Long userId, String name, String surname, String email);

    public Optional<User> getUserById(long id);
}
