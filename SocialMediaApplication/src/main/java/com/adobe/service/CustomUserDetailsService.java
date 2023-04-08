package com.adobe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.adobe.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.adobe.model.User> opt = userRepo.findByEmail(username);

		if(opt.isPresent()) {
			
			com.adobe.model.User user = opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			
			
			return new User(user.getEmail() , user.getPassword(), authorities);
			
			
			
		}else {
			throw new BadCredentialsException("Details not found with this username: "+username);
		}
	}
	
	
}
