package com.spring.constr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Student {

	private String name;
	private int studId;
	private Department department;
	
	
	// NO DEFAULT constructor
	// no need of @Autowired - department will be injected automatically

	public Student(Department department) {
		super();
		this.department = department;
	}
	public String getName() {
		return name;
	}
	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStudId() {
		return studId;
	}
	
	@Value("${student.id}")
	public void setStudId(int studId) {
		this.studId = studId;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", studId=" + studId + ", department=" + department + "]";
	}
	
	
	
}
