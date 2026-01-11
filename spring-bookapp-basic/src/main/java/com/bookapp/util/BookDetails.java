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
				new Book("Java",10,900,"Kathy","tech", LocalDate.of(1996, 10, 30)), 
				new Book("Spring",11,900,"John","tech", LocalDate.of(1996, 10, 30))
		);

	}
}
