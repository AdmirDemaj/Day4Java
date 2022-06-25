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

import java.util.List;

@SpringBootTest
class SpringbootDemoApplicationTests{

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private SPIDServiceImpl spidService;

	@Test
	void test() {
		try {
			User user = new User("Adi", "Demaj", "1234" , "Admir Demaj", "password", "email");
			SPID spid = spidService.addSpid(new SPID());
			System.out.println(userService.getUser(1L));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



}
