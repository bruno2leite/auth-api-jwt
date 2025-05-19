package com.brunoleite.authapijwt.generator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brunoleite.authapijwt.generator.model.User;
import com.brunoleite.authapijwt.generator.service.JwtService;
import com.brunoleite.authapijwt.generator.service.UserService;

@RestController
public class AuthController {
	private final UserService userService;
	private final JwtService jwtService;
	
	public AuthController(UserService userService, JwtService jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		if (userService.register(user)) return ResponseEntity.ok("User Registered!");
		return ResponseEntity.badRequest().body("User already exists");
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		if(userService.authenticate(user)) {
			String token = jwtService.generateToken(user.getUsername());
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(401).body("Invalid Credentials");
	}
	
	@GetMapping("/secure")
	public ResponseEntity<String> securedEndpoint(){
		return ResponseEntity.ok("You are authenticated");
	}
}
