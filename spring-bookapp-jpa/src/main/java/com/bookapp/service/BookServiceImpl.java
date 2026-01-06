package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.repository.IBookRepository;

@Service
//@RequiredArgsConstructor
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
		return books.stream()
		     .map(book->mapper.map(book, BookDto.class))
		     .toList();
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

}






