package com.employeeapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.Category;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.Mode;
import com.employeeapp.service.ICourseService;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringJpaManytomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaManytomanyApplication.class, args);
	}

	@Autowired
	private ICourseService courseService;
	@Autowired
	private IEmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {
		// add course to database;
		CourseDto courseDto1 = new CourseDto(null, "Java", Mode.ONLINE, Category.BE.getCategory(), 
				CourseLevel.BEGINNER,"Priya", null);
//		courseService.addCourse(courseDto1);
		CourseDto courseDto2 = new CourseDto(null, "Gen AI", Mode.ONLINE, Category.ML.getCategory(), 
				CourseLevel.BEGINNER,"Priya", null);
//		courseService.addCourse(courseDto2);
		CourseDto courseDto3 = new CourseDto(null, "React", Mode.OFFLINE, Category.FE.getCategory(), 
				CourseLevel.INTERMEDIATE,"Jo", null);
//		courseService.addCourse(courseDto3);
		
		// for working with employee
		
		// get 3 courseDtos by id
		CourseDto courseDto11 = courseService.getById(13);
		CourseDto courseDto22 = courseService.getById(12);
		CourseDto courseDto33 = courseService.getById(11);
//		create a list
		List<CourseDto> coursesList = Arrays.asList(courseDto11,courseDto22,courseDto33);
//		System.out.println(coursesList);
		//add to a set
		Set<CourseDto> courses = new HashSet<>(coursesList);
		// create employeeDtos and add course to employee
		EmployeeDto employee = new EmployeeDto(null, "Jo", "Admin", "Bengaluru", courses);
//		employeeService.addEmployee(employee);
		
//		System.out.println();
		employeeService.getAll().forEach(System.out::println);
//		
		System.out.println();
		employeeService.getByCity("Bengaluru").forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		employeeService.getByCourseName("ML").forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		employeeService.getByCourseNameAndLevel("Java",CourseLevel.BEGINNER).forEach(System.out::println);
//		
		System.out.println();
		System.out.println();
		employeeService.getByCourseNameAndMode("React",Mode.ONLINE).forEach(System.out::println);
//		
		
	}

	
	
	
	
	
	
	
	
	
	
}
