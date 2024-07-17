package com.exam.service;

import java.util.*;

import com.exam.model.JwtRequest;
import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {
	
	//create user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	public User getUser(String username);

	public void deleteUser(Long userId);
	
	public User updateUser(User user) throws Exception;

	public User passwordAuthUser(JwtRequest jwtRequest) throws Exception;
	
}
