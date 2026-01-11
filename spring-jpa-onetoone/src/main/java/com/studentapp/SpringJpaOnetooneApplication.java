package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.AddressDto;
import com.studentapp.model.StudentDto;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringJpaOnetooneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetooneApplication.class, args);
	}

	@Autowired
	private IStudentService studentService;
	
	@Override
	public void run(String... args) throws Exception {
		AddressDto address =  new AddressDto(null,"Bengaluru","KAR");
		StudentDto student = new StudentDto("Ria", null,"CSE", address);
		//save the student
//		studentService.addStudent(student);
		
		studentService.getAll().forEach(System.out::println);
		System.out.println();
		studentService.getByDepartment("CSE").forEach(System.out::println);
		System.out.println();
		studentService.getByCity("Bengaluru").forEach(System.out::println);
		System.out.println();
		
		studentService.getByDeptAndCity("CSE","Bengaluru").forEach(System.out::println);
		System.out.println();
	}

}












