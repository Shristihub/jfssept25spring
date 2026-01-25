package com.employeeapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "employees")
public class CourseDto {
	private Integer courseId;
	private String courseName;
	private Mode mode;
	private String category; // take values from enum web,frontend
	private CourseLevel courseLevel;
	private String instructor;
	private Set<EmployeeDto> employees;
	
	
	

}
