package com.bookapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bookapp.config.AppConfig;
import com.bookapp.model.BookDto;
import com.bookapp.repository.IBookRepository;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner{

    private final IBookRepository IBookRepository;

    private final AppConfig appConfig;

    private final BookServiceImpl bookServiceImpl;

    SpringBookappJpaApplication(BookServiceImpl bookServiceImpl, AppConfig appConfig, IBookRepository IBookRepository) {
        this.bookServiceImpl = bookServiceImpl;
        this.appConfig = appConfig;
        this.IBookRepository = IBookRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJpaApplication.class, args);
	}
	
	
	@Autowired
	private IBookService bookService;

	@Override
	public void run(String... args) throws Exception {
		BookDto bookDto = new BookDto("Java Essentials",null, 1000,"Robert","tech", LocalDate.of(1999, 10, 10));
		//call the method of bookService
//		bookService.addBook(bookDto);
		
		bookDto = new BookDto("Java in Action",null, 870,"Steve","tech", LocalDate.of(2008, 12, 12));
//		bookService.addBook(bookDto);
		
		bookDto = new BookDto("Learn Java in 10 days",null, 560,"Michael","tech", LocalDate.of(2008, 12, 12));
//		bookService.addBook(bookDto);
		System.out.println();
		System.out.println();
		bookService.getSortedBooks("category","title").forEach(System.out::println);
		
		System.out.println();
//		BookDto bookdt = bookService.getById(1);
//		System.out.println(bookdt);
//		
//		//update book
//		bookdt.setAuthor("Michael");
//		bookdt.setPrice(1090);
//		bookService.updateBook(bookdt);
//		System.out.println();
//		//get by Id
//		bookdt = bookService.getById(1);
//		System.out.println(bookdt);
//		
//		System.out.println();
//		System.out.println("By Author........");
//		bookService.getByAuthor("Robin").forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("By Price........");
//		bookService.getByLesserPrice(1000).forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("By category........");
//		bookService.getByCategory("Tech").forEach(System.out::println);
		
//		System.out.println();
//		System.out.println("By Author and price........");
//		bookService.getByAuthorPrice("Robin",1000).forEach(System.out::println);
		
//		System.out.println();
//		System.out.println("By category and title........");
//		bookService.getByCategoryTitleContains("tech","Java").forEach(System.out::println);
		
//		System.out.println();
//		System.out.println("By Author and category........");
//		bookService.getByCatAuth("tech","Kathy").forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("By above avg price........");
		System.out.println("...........above avg");
		bookService.findAboveAvgPrice().forEach(System.out::println);
		
		bookService.updateBook(54, 640);
		
		BookDto bookdt = new BookDto();
		bookdt.setBookId(1);
		bookdt.setPrice(3000);
		// using jpql- remaining properties as null
		bookService.updateBook(bookdt);
		
	}

}
