package com.web.springboot.demo.controller;

import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/api")
public class UserController {

    UserServiceImpl userService;
    UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


   @PostMapping("/create/person")
   public ResponseEntity<User> addUser(
           @RequestBody User user ) throws Exception {
       log.info(user.getName());
       userService.addUser(user);
       return new ResponseEntity(user, HttpStatus.OK);
   }

   @PutMapping("/edit/person")
    public ResponseEntity<User> editUserById(
            @RequestBody User user,
            @PathVariable(name = "id") long id ) throws Exception{
       user.setId(id);
       return new ResponseEntity(userService.addUser(user), HttpStatus.OK);
   }


}
