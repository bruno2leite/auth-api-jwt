package com.brunoleite.authapijwt.generator.service;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 3600000))
				.signWith(key)
				.compact();
	}
	
	/*public boolean validToken(String token, String username) {
		return getUsernameFromToken(token).equals(username);
	}*/
	
	public String getUsernameFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
}
