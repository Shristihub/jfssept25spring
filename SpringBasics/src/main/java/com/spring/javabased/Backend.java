package com.spring.javabased;

import java.util.List;

public class Backend implements ICourse{

	@Override
	public List<String> showCourses() {
		return List.of("Spring","Java");
	}

	
}
