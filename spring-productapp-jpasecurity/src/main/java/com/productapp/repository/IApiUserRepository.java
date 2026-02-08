package com.productapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.productapp.model.entities.ApiUser;

public interface IApiUserRepository extends JpaRepository<ApiUser, Integer>{

	@Query("select au from ApiUser au join fetch au.roles where au.username=?1 ")
	Optional<ApiUser> findByUsername(String username);
}
