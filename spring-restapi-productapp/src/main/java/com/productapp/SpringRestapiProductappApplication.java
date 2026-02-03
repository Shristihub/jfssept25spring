package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringRestapiProductappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringRestapiProductappApplication.class, args);
	}

	@Autowired
	private IProductService productService;
	@Override
	public void run(String... args) throws Exception {

//		productService.getAll().forEach(System.out::println);
	}

}
