package com.spring.javabased;

import org.springframework.beans.factory.annotation.Autowired;

public class Institute {

	@Autowired
	ICourse course;
	
	void courseDetails(){
		System.out.println("Courses offered");
		course.showCourses().forEach(System.out::println);
	
	
	}

}










