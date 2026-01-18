package com.employeeapp.config;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.Employee;
import com.employeeapp.model.EmployeeDto;

@Component
public class EmployeeMapper {

	@Autowired
	private ModelMapper mapper;

	public EmployeeDto convertToEmployeeDto(Employee employee) {
		//get the courses from employees and covert to dto
		Set<CourseDto> courseDtos = employee.getCourses().stream()
				.map(course->convertToCourseDto(course))
				.collect(Collectors.toSet());
		// get the employeeDto from employee
		EmployeeDto employeeDto = mapper.map(employee,EmployeeDto.class);
		// set the coursedtos to employeeDto
		employeeDto.setCourses(courseDtos);
		return employeeDto; 
	}

	public List<EmployeeDto> convertToEmployeeDto(List<Employee> employees) {

		//convert employees to a stream, get one employee convert to dto
		// convert course to dto and add coursedto to employeedto and return list
//		return employeeDtos;
		return null;
	}
	
	
	public Employee convertToEmployeeEntity(EmployeeDto employeeDto) {
		return mapper.map(employeeDto,Employee.class);
	}

	public CourseDto convertToCourseDto(Course course) {
		return mapper.map(course, CourseDto.class);
	}

	public Course convertToCourseEntity(CourseDto courseDto) {
		return mapper.map(courseDto, Course.class);
	}
}
