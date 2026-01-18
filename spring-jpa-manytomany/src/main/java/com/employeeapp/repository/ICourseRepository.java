package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer>{

	
}
