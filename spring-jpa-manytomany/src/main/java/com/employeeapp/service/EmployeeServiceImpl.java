package com.employeeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employeeapp.config.EmployeeMapper;
import com.employeeapp.model.CourseLevel;
import com.employeeapp.model.Employee;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.Mode;
import com.employeeapp.repository.IEmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{
	
	private final IEmployeeRepository employeeRepository;
	private final EmployeeMapper mapper;

	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.convertToEmployeeEntity(employeeDto);
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.convertToEmployeeEntity(employeeDto);
		employeeRepository.save(employee);		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

	@Override
	public EmployeeDto getById(int employeeId) {
		Optional<Employee> optemployee = employeeRepository.findById(employeeId);
		if(optemployee.isPresent()) {
			Employee employee = optemployee.get();
			return mapper.convertToEmployeeDto(employee);
		}
			
		return null;
	}

	@Override
	public List<EmployeeDto> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		//convert employees to stream-> modify one by one employee to dto
		List<EmployeeDto> employeeDtos = employees.stream()
									.map(employee->mapper.convertToEmployeeDto(employee))
									.toList();
		return employeeDtos;
	}

	@Override
	public List<EmployeeDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getByCourseNameAndLevel(String courseName, CourseLevel level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getByCourseNameAndMode(String courseName, Mode mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
