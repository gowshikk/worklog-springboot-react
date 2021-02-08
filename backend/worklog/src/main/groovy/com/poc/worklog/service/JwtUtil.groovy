package com.poc.worklog.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import io.jsonwebtoken.*;

@Service
class JwtUtil {

	private String secretkey = "secret";

	public String extractUsername(String token) {
		final Claims claims = Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
		String userName = claims.getSubject();
		return userName;
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}
	
	private String createToken(Map<String, Object> claims, String subject) {
		return  Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*10))
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
	}
	
	public Boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token).getBody();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
