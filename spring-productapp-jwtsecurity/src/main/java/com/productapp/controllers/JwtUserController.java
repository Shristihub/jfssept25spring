package com.productapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.JwtUserDto;
import com.productapp.model.entities.JwtUser;
import com.productapp.service.impl.JwtUserServiceImpl;
import com.productapp.util.JwtTokenUtil;
import com.productapp.util.UserMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/user-api/v1")
public class JwtUserController {
     //autowire these
	 JwtUserServiceImpl jwtUserService;
	 PasswordEncoder encoder;
	 UserMapper userMapper;
	 JwtTokenUtil jwtTokenUtil;
	
	 @PostMapping("/register")
	 ResponseEntity<Void> createUser(@RequestBody JwtUserDto jwtUserDto){
		 //get the password and encode it
		 String password =jwtUserDto.getPassword();
		 // encodepassword
		 String newpassword = encoder.encode(password);
		 //  set the new password to the userdto object
		jwtUserDto.setPassword(newpassword);
		 // use modelmapper to convert dto to entity
		 JwtUser jwtUser= userMapper.converttoEntity(jwtUserDto);
		 // call the method of service;
		jwtUserService.createUser(jwtUser);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	 }
	 
	 @PostMapping("/login")
	 ResponseEntity<String> authorizeUser(@RequestBody JwtUserDto jwtUserDto){
		 // get the username from the request
		 String username = jwtUserDto.getUsername();
		 // call the method of service - this returns a userdetails object
		UserDetails userDetails = jwtUserService.loadUserByUsername(username);
	    // call the method of JwtTokenUtil to generate the token 
		// the token will have this userdetails objects
	    String token = jwtTokenUtil.generateToken(userDetails);
		 return ResponseEntity.ok(token);
	 
	 }
	 
}








