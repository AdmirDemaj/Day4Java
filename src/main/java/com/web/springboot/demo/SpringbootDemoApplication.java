package com.web.springboot.demo;

import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import com.web.springboot.demo.entities.User;
import com.web.springboot.demo.service.SpidService;
import com.web.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ComponentScan("com.web.springboot.demo")
@EnableAutoConfiguration
@Configuration
public class SpringbootDemoApplication implements CommandLineRunner {

	@Autowired
	public UserService userService;

	@Autowired
	public SpidService spidService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> UserList = new ArrayList<>();

		//Create User
		User createdUser = userService.createUser(new User(1, new Date(),new Date(),"Admir", "Admir Demaj", "Demaj"));
		User createdUser1 = userService.createUser(new User(3, new Date(),new Date(),"Jeff", "Jeff Scott", "Scott"));
		System.out.println("User i krijuar eshte: " + createdUser.getUsername());
		UserList.add(createdUser);
		UserList.add(createdUser1);

		//Create SPID
		SPID createSPID = spidService.createService(new SPID(1, new Date(), new Date(), "Description1", Status.PENDING, createdUser));
		System.out.println("SPID e krijuar eshte: " + createSPID.getDescription() + " for User " + createSPID.getUser().getUsername());

		//Edit User
		UserService.editUser(createdUser, 2, new Date(), new Date() , "Dean", "Dean Meko", "Meko");
		System.out.println("This user is edited: " + createdUser.getUsername());


		//Edit SPID
		SpidService.editSPID(createSPID, 2, new Date(), new Date(), "Another Description", Status.APPROVED, createdUser);
		System.out.println("This SPID is edited: " + createSPID.getStatus() + " "  + createSPID.getUser().getUsername());

		//Iterating through list of created users
		UserList.forEach(users -> {
			System.out.println(users.getUsername());
		});
	}


}
