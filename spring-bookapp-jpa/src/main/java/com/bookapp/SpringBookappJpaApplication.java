package com.bookapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bookapp.config.AppConfig;
import com.bookapp.model.BookDto;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner{

    private final AppConfig appConfig;

    private final BookServiceImpl bookServiceImpl;

    SpringBookappJpaApplication(BookServiceImpl bookServiceImpl, AppConfig appConfig) {
        this.bookServiceImpl = bookServiceImpl;
        this.appConfig = appConfig;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJpaApplication.class, args);
	}
	
	
	@Autowired
	private IBookService bookService;

	@Override
	public void run(String... args) throws Exception {
		BookDto bookDto = new BookDto("Java in Action",null, 900,"Kathy","Tech", LocalDate.of(1999, 10, 10));
		//call the method of bookService
		bookService.addBook(bookDto);
		
		bookDto = new BookDto("Spring in Action",null, 1200,"Steve","Tech", LocalDate.of(2008, 12, 12));
		bookService.addBook(bookDto);
		
		bookService.getAll().forEach(System.out::println);
		
		System.out.println();
		BookDto bookdt = bookService.getById(1);
		System.out.println(bookdt);
		
		//update book
		bookdt.setAuthor("Michael");
		bookdt.setPrice(1090);
		bookService.updateBook(bookdt);
		System.out.println();
		//get by Id
		bookdt = bookService.getById(1);
		System.out.println(bookdt);
		
		
		
	}

}
