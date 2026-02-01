package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bookapp.model.Book;
import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {

	// derived queries
	// readBy, getBy, queryBy, findBy folowed by the property name
	List<Book> findByAuthor(String author);

	List<Book> queryByPriceLessThan(double price);

	List<Book> readByCategory(String category);

	// Custom Query
	// select * from book where author = 'Kathy' and price <1000
	// use only property name
	@Query("from Book b where b.author =?1 and b.price<?2")
	List<Book> findByAuthorPrice(String author, double price);

//	 select * from book where category = 'tech' and title like '%java%'
  	@Query("from Book b where b.category=?1 and b.title like ?2")
	List<Book> findByCategoryTitle(String category, String title);
  	
  	
  	//NamedQuery
  	@Query(name = "fetchByCategoryAuthor")
  	List<Book> readByCatAuth(String category, String author);
  	
  	
  	//CustomQuery
//  	@Query(value = "select b from Book b where b.price>(select avg(b.price) from Book b)")
  	//nativequery
  	@Query(value="select * from book where cost>(select avg(b.cost) from Book b)",nativeQuery = true)
  	List<Book> findAboveAvgPrice();
  	
  	
   //NamedNativeQuery - multi row sub query
  	@Query(name = "fetchAll",nativeQuery = true)
  	List<Book> findAllBooks();

  	@Modifying
  	@Query(value = "update book set cost=?2 where book_Id=?1",nativeQuery = true)
	void updateBook(int bookId, double price);
  	
  	
}









