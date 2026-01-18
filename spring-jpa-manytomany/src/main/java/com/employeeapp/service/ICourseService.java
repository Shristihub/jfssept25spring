package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.CourseDto;

public interface ICourseService {

	void addCourse(CourseDto courseDto);
	void updateCourse(CourseDto courseDto);
	void deleteCourse(int courseId);
	CourseDto getById(int courseId);
	
	
	List<CourseDto> getByEmployeeId(int empId);
	List<CourseDto> getByMode(String mode); // list of online courses
	List<CourseDto> getByModeCategory(String mode, String category); // list of frontend online courses
	//list of online courses  by a particular depratment employees
	List<CourseDto> getByDepartmentMode(String department,String mode);
	
	
}
