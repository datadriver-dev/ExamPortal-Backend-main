package com.exam;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting code");
		
		// creating a hardcoded user
		User user = new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setUsername("admin");
		user.setPassword(this.passwordEncoder.encode("admin@mail.com"));
		user.setEmail("admin@mail.com");
		user.setProfile("default.png");
		
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		
		User createdUser = this.userService.createUser(user, userRoleSet);
		System.out.println(createdUser.getUsername());
		
	}

}
