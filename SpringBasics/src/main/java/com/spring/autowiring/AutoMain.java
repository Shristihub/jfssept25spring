package com.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring");
		ShapeFactory factory = context.getBean("shapeFactory",ShapeFactory.class);
		factory.printArea(10, 20);
		
		
		
	}
}
