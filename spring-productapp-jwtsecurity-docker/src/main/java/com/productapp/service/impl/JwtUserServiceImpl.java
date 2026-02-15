package com.productapp.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.JwtUser;
import com.productapp.repository.IJwtUserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class JwtUserServiceImpl implements UserDetailsManager{
	
	IJwtUserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser apiUser =  userRepository.findByUsername(username)
					.orElseThrow(()-> new UsernameNotFoundException("invalid name/id"));
		System.out.println(apiUser);
		//create an userdetails object manually
		UserDetails userDetails = 
				 new User(apiUser.getUsername(), apiUser.getPassword(),apiUser.getAuthorities());
		// return the object
		System.out.println(userDetails);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		//pass the class that is annotated with @Entity
		// we need ApiUser object what is here is an UserDetails object
		JwtUser apiUser = (JwtUser)user;
		userRepository.save(apiUser);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
