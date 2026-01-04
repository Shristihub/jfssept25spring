package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.autowiring.Player;
import com.example.javabased.Theatre;
import com.spring.setter.Employee;

@SpringBootApplication(scanBasePackages = {"com.spring","com.example"})
public class SpringBootBasicsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicsApplication.class, args);
	}
//	@Autowired
//	private ApplicationContext context;
	
	@Autowired
	private Employee employee;
	@Autowired
	private Player player;
	
	@Autowired
	private Theatre theatre;

	@Override
	public void run(String... args) throws Exception {
		
		// the beans created by APplicationcontext
//		  Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
		// print the employee object
		System.out.println(employee);
		player.playGames("o");
		
		theatre.runningMovies().forEach(System.out::println);
		
		
	}

}




