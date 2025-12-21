package com.spring.autowiring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowireMain {

	public static void main(String[] args) {
		//create ioc container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring1");
		Player player =  context.getBean("player",Player.class);
		player.playGames("out");
		player.playGames("in");
		
		
		
	}
}
