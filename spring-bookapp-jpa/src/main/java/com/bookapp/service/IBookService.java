package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.BookDto;

public interface IBookService {
	
	//crud operation
	void addBook(BookDto bookDto);
	void updateBook(BookDto bookDto);
	void deleteBook(int bookId);
	
	List<BookDto> getAll();
	BookDto getById(int bookId)throws BookNotFoundException;
	
	
	
	

}
