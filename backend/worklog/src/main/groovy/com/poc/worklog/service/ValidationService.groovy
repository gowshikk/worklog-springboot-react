package com.poc.worklog.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
@Component
class ValidationService {

	@Autowired
	private JwtUtil jwtutil;
	

	public String validate(String token) {

		String jwt = token.substring(7);

		if (jwtutil.validateToken(jwt)) {
			return jwtutil.extractUsername(jwt);
		} else {
			return "Not Valid";
		}
	}
}
