package com.spring.setter;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.setter");
		
		// see the beans created by APplicationcontext
	  Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		
		// get the object from the IoC Container
		Employee employee =  (Employee) context.getBean("employee");
		System.out.println(employee);
		
		
	}
}
