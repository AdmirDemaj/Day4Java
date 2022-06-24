package com.web.springboot.demo;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.entities.Type;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.service.SPIDService;
import com.web.springboot.demo.service.SPIDServiceImpl;
import com.web.springboot.demo.service.UserService;
import com.web.springboot.demo.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private SPIDServiceImpl spidService;

	@Test
	void contextLoads() {
		User user = userService.addUser(new User("Admir", "Demaj", "1", "Admir Demaj", "1234", "adidemaj@yahoo.com"));
		SPID spid = spidService.addSpid(new SPID(user , Status.PENDING, Type.LEVEL_2));
		System.out.println(userService.getUserById(1));
		System.out.println(spidService.getSpidByUserId(spid, user));

	}

}
