package com.web.springboot.demo.service;

import com.web.springboot.demo.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {UserServiceImpl.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceImplTest {

    @Mock
    UserServiceImpl userService;

    @Test
    public void testDatabaseforUsers(){
        assertInstanceOf(User.class, userService.getUserById(1).get());
    }

}