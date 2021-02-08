package com.poc.worklog.service

import com.poc.worklog.models.AppUser
import com.poc.worklog.service.exception.AppUserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class LoginService {
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailservice;
	
	public String userLogin(AppUser appuser) throws AppUserNotFoundException {
		final UserDetails userdetails = customUserDetailservice.loadUserByUsername(appuser.getUsername());
		String username = "";
		String token="";
		if (userdetails.getPassword().equals(appuser.getPassword()) ) {
			username = appuser.getUsername();
			token = jwtutil.generateToken(userdetails);
			return token;
		} else {
			throw new AppUserNotFoundException("Username/Password is incorrect...Please check");
		}
	}
	
	
	
	}
