package com.web.springboot.demo.service;

import com.web.springboot.demo.controller.SPIDController;
import com.web.springboot.demo.controller.UserController;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UserController.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {

    UserRepository userRepository;

    @Test
    void addUser() {
        User user = new User();
        user.setName("Name");
        user.setEmail("Test@email");
        user.setId(1L);
        user.setSurname("Surname");
        user.setPassword("password");
        user.setCardNo("121345");
    }

    @Test
    void getUser() {
        User user = userRepository.findById(1L).get();
    }


}
