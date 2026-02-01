package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

@Service
public class BookServiceImpl implements IBookService{
	
	private BookDetails bookDetails;
	
	// constructor based DI
	public BookServiceImpl(BookDetails bookDetails) {
		super();
		this.bookDetails = bookDetails;
	}

	@Override
	public List<Book> getAll() {
		return bookDetails.showBooks();
	}

	@Override
	public List<Book> getByAuthorContains(String choice) throws BookNotFoundException {
		List<Book> books = bookDetails.showBooks()
							.stream()
							.filter(book->book.getAuthor().contains(choice))
							.toList();
		return books;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = bookDetails.showBooks();
//		List<Book> newbooks = new ArrayList<>();
//		for (Book book2 : books) {
//			if(book2.getCategory().equals(category))
//				newbooks.add(book2);
//		}
//		return newbooks;
		
		//convert books to stream, filter, sort and convert back to list
		List<Book> booksByCategory = books.stream()
		     .filter(book->book.getCategory().equals(category))
//		     .sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle()))
		     .sorted(Comparator.comparing(Book::getTitle))
		     .toList();
		//..check if empty - throw exception
		if(booksByCategory.isEmpty())
			throw new BookNotFoundException("book with this category not found");
		return booksByCategory;
	}

	@Override
	public long getCountOfBooksByAuthor(String author) throws BookNotFoundException {
		 long totalcount = bookDetails.showBooks()
			.stream()
			.filter(book->book.getAuthor().equals(author))
			.count();
		 return totalcount;
	}

	@Override
	public List<String> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = bookDetails.showBooks();
		
		List<String> booksByPrice = books.stream()
			     .filter(book->book.getPrice()<price)
			     .sorted(Comparator.comparing(Book::getTitle))
			     .map(Book::getTitle)
			     .toList();
			//.check if empty - throw exception
			if(booksByPrice.isEmpty())
				throw new BookNotFoundException("book with less than this price not found");
			return booksByPrice;
	}

	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
      List<Book> books = bookDetails.showBooks();
		
		List<Book> booksByYear = books.stream()
			     .filter(book->book.getDatePublished().getYear()==year)
			     .toList();
			 //.check if empty - throw exception
	  if(booksByYear.isEmpty())
		throw new BookNotFoundException("book with less than this price not found");
	  return booksByYear;
	     
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
//		Optional<Book> optBook = bookDetails.showBooks()
//		           .stream()
//		           .filter(book->book.getBookId()==bookId)
//		           .findFirst();
//		if(optBook.isPresent())
//			return optBook.get();
//		return null;
		
		return bookDetails.showBooks()
		           .stream()
		           .filter(book->book.getBookId()==bookId)
		           .findFirst()
		           .orElseThrow(()->new BookNotFoundException("invalid id"));
		
		
		
	}

}
