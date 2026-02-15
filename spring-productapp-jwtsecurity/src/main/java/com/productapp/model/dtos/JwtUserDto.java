package com.productapp.model.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class JwtUserDto {
	private String username;
	private String password;
	private Integer jwtuserId;
	private Set<String> roles;

}
