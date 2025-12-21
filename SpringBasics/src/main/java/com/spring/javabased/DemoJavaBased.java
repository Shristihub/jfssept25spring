package com.spring.javabased;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoJavaBased {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.spring.javabased");
//		
//		// see the beans created by APplicationcontext
		  Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
//			
		 Institute ins = context.getBean("institute",Institute.class);	
		 ins.courseDetails();
	}
}
