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
		// get the employeedto from employee
		EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

		// get the courses from the employee
		Set<Course> courses = employee.getCourses();
		System.out.println(courses);
		
		// convert courses to courseDtos
		// use map method of streams to convert course to courseDto
		Set<CourseDto> courseDtos = courses.stream().map(course -> convertToCourseDto(course))
				.collect(Collectors.toSet());

		// attach the courseDtos to employeeDto
		employeeDto.setCourses(courseDtos);
		return employeeDto;
	}

	public List<EmployeeDto> convertToEmployeeDto(List<Employee> employees) {

		// convert employees to a stream, get one employee convert to dto
		// convert course to dto and add coursedto to employeedto and return list
		// convert employees to stream- get one emp object
		List<EmployeeDto> employeeDtos = employees.stream()
											.map(employee ->convertToEmployeeDto(employee))
											.toList();
		return employeeDtos;
	}

	public Employee convertToEmployeeEntity(EmployeeDto employeeDto) {
		return mapper.map(employeeDto, Employee.class);
	}

	public CourseDto convertToCourseDto(Course course) {

		return mapper.map(course, CourseDto.class);
	}

	public Course convertToCourseEntity(CourseDto courseDto) {
		return mapper.map(courseDto, Course.class);
	}
}
