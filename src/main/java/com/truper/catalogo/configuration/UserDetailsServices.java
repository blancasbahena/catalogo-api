package com.truper.catalogo.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServices implements UserDetailsService{


	@Value("${api.access.user}")
	private String user;

	@Value("${api.access.password}")
	private String password;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username.equals(user)) {
			return new User(username, password, true, true, true, true, new ArrayList<>());
		}
		throw new UsernameNotFoundException("User not found with username: " + username);

	}

	

}
