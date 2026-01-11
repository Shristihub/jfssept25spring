package com.bookapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import com.bookapp.util.BookDetails;

@SpringBootApplication
public class SpringBookappBasicApplication implements CommandLineRunner{

    private final BookServiceImpl bookServiceImpl;

    private final BookDetails bookDetails;

    SpringBookappBasicApplication(BookDetails bookDetails, BookServiceImpl bookServiceImpl) {
        this.bookDetails = bookDetails;
        this.bookServiceImpl = bookServiceImpl;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappBasicApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	
	
	@Override
	public void run(String... args) throws Exception {
		bookService.getAll().forEach(System.out::println);
		System.out.println();
		
		bookService.getByCategory("tech").forEach(System.out::println);
		
		Book book =bookService.getById(100);
		System.out.println(book);
	}

}
