package com.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeeapp.config.EmployeeMapper;
import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.repository.ICourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService{
	
	private final ICourseRepository courseRepository;
	private final EmployeeMapper mapper;
  
	@Override
	public void addCourse(CourseDto courseDto) {
		Course course = mapper.convertToCourseEntity(courseDto);
		courseRepository.save(course);
	}

	@Override
	public void updateCourse(CourseDto courseDto) {
		Course course = mapper.convertToCourseEntity(courseDto);
		courseRepository.save(course);		
	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
		
	}

	@Override
	public CourseDto getById(int courseId) {
		Optional<Course> optcourse = courseRepository.findById(courseId);
		if(optcourse.isPresent()) {
			Course course = optcourse.get();
			return mapper.convertToCourseDto(course);
		}
			
		return null;
	}

	@Override
	public List<CourseDto> getByEmployeeId(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> getByMode(String mode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> getByModeCategory(String mode, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseDto> getByDepartmentMode(String department, String mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
