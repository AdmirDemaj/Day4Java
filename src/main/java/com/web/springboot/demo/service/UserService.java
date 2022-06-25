package com.web.springboot.demo.service;




import com.web.springboot.demo.entities.Type;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public User addUser(User user) throws Exception;
    public Optional<User> getUser(long id) throws Exception;
    public User editUserById(User user, long id) throws Exception;

}

