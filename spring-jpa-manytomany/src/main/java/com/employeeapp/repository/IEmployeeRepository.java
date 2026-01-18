package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
