package com.poc.worklog.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.poc.worklog.models.AppUser
import com.poc.worklog.repository.AppUserRepository
import com.poc.worklog.service.JwtUtil
import com.poc.worklog.service.LoginService
import com.poc.worklog.service.ValidationService
import com.poc.worklog.service.exception.AppUserNotFoundException

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RefreshScope
@RequestMapping("/jwt")
class JwtController {
	
	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private JwtUtil jwtutil;

	@PostMapping("/saveUser")
	public AppUser saveUser(@RequestBody AppUser user)
	{
		println (user.getUsername()+"    "+user.getPassword());
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@GetMapping("/check")
	public ResponseEntity<String> checkup(@RequestHeader("Authorization") final String token) {
			return new ResponseEntity<>(validationService.validate(token), HttpStatus.OK);			
		
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> login(@RequestBody AppUser appUserloginCredentials) throws AppUserNotFoundException, AppUserNotFoundException {
		String token = loginService.userLogin(appUserloginCredentials);
		println(token);
		return new ResponseEntity<>(token , HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/validate")
	@CrossOrigin(origins = "http://localhost:3000")
	public String getValidity(@RequestHeader("Authorization") final String token) {
		String validated =  validationService.validate(token);
		println(validated);
		return validated;
	}

}
