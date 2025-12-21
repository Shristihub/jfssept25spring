package com.spring.autowiring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Player {

	@Autowired
	@Qualifier("outdoor")
	ISports sports; // new Outdoor()

	@Autowired
	ISports indoor; // = new Indoor() 
	
	void playGames(String type){
		
	  System.out.println("Choose game in club");
	  if(type.equals("o"))
		  sports.gamesAvailable().forEach(System.out::println);
	  else
		  indoor.gamesAvailable().forEach(System.out::println);
	}

}










