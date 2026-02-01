package com.bookapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {

	// autowire IBookService
	private IBookService bookService;

	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}
//	http://localhost:8080/book-api/v1/books
	@GetMapping("/books")
	List<Book> getAll() {
		return bookService.getAll();
	}

//	http://localhost:8080/book-api/v1/books/author/o
	@GetMapping("/books/author/{choice}")
	List<Book> getByAuthorContains(@PathVariable String choice) {
		return bookService.getByAuthorContains(choice);
	}

//	http://localhost:8080/book-api/v1/books/category?category=selfhelp
	@GetMapping("/books/category")
	List<Book> getByCategory(@RequestParam String category) {
		return bookService.getByCategory(category);
	}

//	http://localhost:8080/book-api/v1/books/bookId/12
	@GetMapping("/books/bookId/{bookId}")
	Book getById(@PathVariable int bookId) {
		return bookService.getById(bookId);
	}

 //	http://localhost:8080/book-api/v1/books/price?price=1000
	@GetMapping("/books/price")
	List<String> getByPriceLessThan(@RequestParam double price) {
		return bookService.getByPriceLessThan(price);
	}

//	http://localhost:8080/book-api/v1/books/count/author/{author}
	@GetMapping("/books/count/author/{author}")
	long getCountOfBooksByAuthor(@PathVariable String author) {
		return bookService.getCountOfBooksByAuthor(author);
	}
//	http://localhost:8080/book-api/v1/books/year?year=1999
	@GetMapping("/books/year")
	List<Book> getByDatePublished(@RequestParam int year) {
		return bookService.getByDatePublished(year);
	}
//	http://localhost:8080/book-api/v1/books/property?author=Kathy&category=Tech
	@GetMapping("/books/property")
	List<Book> getByAuthorContainsAndCategory(@RequestParam String author,@RequestParam String category) {
		return bookService.getByAuthorContainsAndCategory(author, category);
	}

}
