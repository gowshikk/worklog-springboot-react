package com.poc.worklog.service

import com.poc.worklog.models.AppUser
import com.poc.worklog.repository.AppUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService implements UserDetailsService{
	public CustomUserDetailsService() {
		super();
	}

	@Autowired
	private AppUserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AppUser user = userRepo.findByUsername(username);
		if (user == null) throw new UsernameNotFoundException(username+" not found")
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
}
