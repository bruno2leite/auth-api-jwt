package com.brunoleite.authapijwt.generator.service;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

import com.brunoleite.authapijwt.generator.model.User;

@Service
public class UserService {
	private final ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();
	
	public boolean register(User user) {
		if(users.containsKey(user.getUsername())) return false;
		users.put(user.getUsername(), user.getPassword());
		return true;
	}
	
	public boolean authenticate(User user) {
		return users.containsKey(user.getUsername()) && 
				users.get(user.getUsername()).equals(user.getPassword());
	}

}
