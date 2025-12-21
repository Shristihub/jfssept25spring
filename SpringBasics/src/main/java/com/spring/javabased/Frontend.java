package com.spring.javabased;

import java.util.List;

public class Frontend implements ICourse{

	@Override
	public List<String> showCourses() {
		return List.of("React","Angular");
	}

	
}
