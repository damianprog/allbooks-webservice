package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.damianprog.oauth.entities.User;
import com.damianprog.repositories.OAuthUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private OAuthUserRepository oAuthUserRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = oAuthUserRepository.findByUsername(username);
	        if (user != null) {
	            return user;
	        }
	        throw new UsernameNotFoundException(username);
	}
	
	
	
}
