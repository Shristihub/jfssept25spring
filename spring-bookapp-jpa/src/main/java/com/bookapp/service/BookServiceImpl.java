package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	private ModelMapper mapper;
	private IBookRepository repository;

	public BookServiceImpl(ModelMapper mapper, IBookRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public void addBook(BookDto bookDto) {
		// convert the dto to book object
		Book book = mapper.map(bookDto, Book.class);
		// call the method of repository to save the entity
		// if the entity does not have id, autogenerate the id and create a new record
		// if the entity has an id - check in db if the record with this id is available
		// if yes -> update the record
		// if no -> create a new record
		repository.save(book);

	}

	@Override
	public void updateBook(BookDto bookDto) {
		// convert the dto to book object
		Book book = mapper.map(bookDto, Book.class);
		// it is a must that you pass the id to update else it will create a new record
		repository.save(book);

	}

	@Override
	public void deleteBook(int bookId) {
		repository.deleteById(bookId);
	}

	@Override
	public List<BookDto> getAll() {
		List<Book> books= repository.findAll();
		return convertToDto(books);
	}

	@Override
	public BookDto getById(int bookId) throws BookNotFoundException {
//		// get the entity by id
		Optional<Book> bookopt = repository.findById(bookId);
		if(bookopt.isPresent()) {
			Book book = bookopt.get();
			//convert entity to dto
			return mapper.map(book,BookDto.class);
		}
		throw new BookNotFoundException("invalid id");
	}

	@Override
	public List<BookDto> getByAuthor(String author) {
		List<Book> books= repository.findByAuthor(author);
		if(books.isEmpty())
		   throw new BookNotFoundException("book by author not available");
		return convertToDto(books);
	}

	@Override
	public List<BookDto> getByLesserPrice( double price) {
		List<Book> books= repository.queryByPriceLessThan(price);
		if(books.isEmpty())
		   throw new BookNotFoundException("book by lesser price not available");
		return convertToDto(books);
	}

	@Override
	public List<BookDto> getByAuthorPrice(String author, double price) throws BookNotFoundException {
		List<Book> books= repository.findByAuthorPrice(author,price);
		if(books.isEmpty())
		   throw new BookNotFoundException("book by author and lesser price not available");
		return convertToDto(books);
	}

	@Override
	public List<BookDto> getByCategoryTitleContains(String category, String title) throws BookNotFoundException {
		List<Book> books= repository.findByCategoryTitle(category, "%"+title+"%");
		if(books.isEmpty())
		   throw new BookNotFoundException("book by author and lesser price not available");
		return convertToDto(books);
	}

	@Override
	public List<BookDto> getByCategory(String category) {
		List<Book> books= repository.readByCategory(category);
		if(books.isEmpty())
		   throw new BookNotFoundException("book by category not available");
		return convertToDto(books);
	}

	private List<BookDto> convertToDto(List<Book> books){
		//convert books to stream, call map method
		return books.stream()
				.map(book->mapper.map(book, BookDto.class)).toList();
	}

	@Override
	public List<BookDto> getByCatAuth(String category, String author) throws BookNotFoundException {
		List<Book> books= repository.readByCatAuth(category, author);
		if(books.isEmpty())
		   throw new BookNotFoundException("book by author not available");
		return convertToDto(books);
	}

	@Override
	public List<BookDto> findAboveAvgPrice() {
		List<Book> books= repository.findAboveAvgPrice();
		if(books.isEmpty())
		   throw new BookNotFoundException("book by author not available");
		return convertToDto(books);
	}

	@Override
	public List<BookDto> getSortedBooks(String... property) {
//		Sort sort = Sort.by("title");
		Sort sort = Sort.by(Direction.DESC, property);
		List<Book> books= repository.findAll(sort);
		return convertToDto(books);
	}

	@Transactional
	@Override
	public void updateBook(int bookId, double price) {
		repository.updateBook( bookId, price);
	}
}






