package com.spring.constr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring");
		
		// see the beans created by APplicationcontext
//	  Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		Student student = context.getBean(Student.class);
		System.out.println(student);
		
		
		
		
		
	}
}
