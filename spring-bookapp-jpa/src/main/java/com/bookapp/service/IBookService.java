package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;

public interface IBookService {
	
	//crud operation
	void addBook(BookDto bookDto);
	void updateBook(BookDto bookDto);
	void deleteBook(int bookId);
	
	List<BookDto> getAll();
	BookDto getById(int bookId)throws BookNotFoundException;
	
	//derived queries
	List<BookDto> getByAuthor(String author)throws BookNotFoundException;
	List<BookDto> getByLesserPrice(double price)throws BookNotFoundException;
	List<BookDto> getByCategory(String category)throws BookNotFoundException;
	
	//custom query
	List<BookDto> getByAuthorPrice(String author, double price)throws BookNotFoundException;
	List<BookDto> getByCategoryTitleContains(String category,String title)throws BookNotFoundException;
	
	//named query
	List<BookDto> getByCatAuth(String category,String author)throws BookNotFoundException;
	
	//native query
	List<BookDto> findAboveAvgPrice();
	
	

}
