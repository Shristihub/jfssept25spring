package com.bookapp.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookDetails {

	// this is for providing book data as we dont have db

	public List<Book> showBooks() {
		return Arrays.asList(
				new Book("HeadFirst Java",10,300,"Kathy","tech", LocalDate.of(1996, 10, 30)), 
				new Book("Spring",11,1200,"John","tech", LocalDate.of(1996, 10, 30)),
				new Book("JSP and Servlets",12,800,"Kathy","tech", LocalDate.of(1996, 10, 30)), 
				new Book("Design Patterns",13,900,"Kathy","tech", LocalDate.of(1996, 10, 30)),
				new Book("5am",14,340,"Robin","selfhelp", LocalDate.of(1996, 10, 30)), 
				new Book("Seven Habits",15,1020,"Steve","selfhelp", LocalDate.of(1996, 10, 30))
		);

	}
}
