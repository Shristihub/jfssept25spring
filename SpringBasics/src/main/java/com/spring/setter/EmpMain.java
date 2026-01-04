package com.spring.setter;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.setter");
		
		// see the beans created by APplicationcontext
//	  Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		
		// get the object from the IoC Container
		Employee employee =  (Employee) context.getBean("employee");
		// new bean with same values
		Employee employee1 =  (Employee) context.getBean("employee",Employee.class);
		System.out.println(employee.getEmployeeName());
		System.out.println(employee1.getEmployeeName());
		employee.setEmployeeName("Sri");
		System.out.println(employee.getEmployeeName());
		System.out.println(employee1.getEmployeeName());
	}
}
