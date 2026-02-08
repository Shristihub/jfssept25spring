package com.productapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.ApiUserDto;
import com.productapp.model.entities.ApiUser;
import com.productapp.service.impl.ApiUserServiceImpl;
import com.productapp.util.UserMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class ApiUserController {
     //autowire these
	 ApiUserServiceImpl apiUserService;
	 PasswordEncoder encoder;
	 UserMapper userMapper;
	
	 @PostMapping("/register")
	 ResponseEntity<Void> createUser(@RequestBody ApiUserDto apiUserDto){
		 //get the password and encode it
		 String password = apiUserDto.getPassword();
		 // encodepassword
		 String newpassword = encoder.encode(password);
		 //  set the new password to the userdto object
		 apiUserDto.setPassword(newpassword);
		 // use modelmapper to convert dto to entity
		 ApiUser apiUser= userMapper.converttoEntity(apiUserDto);
		 // call the method of service;
		 apiUserService.createUser(apiUser);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	 }
}








