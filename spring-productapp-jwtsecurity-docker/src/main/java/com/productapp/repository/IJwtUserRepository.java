package com.productapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.entities.JwtUser;

public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer>{

	@Query("select au from JwtUser au join fetch au.roles where au.username=?1 ")
	Optional<JwtUser> findByUsername(String username);
}
