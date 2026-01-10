package com.bookapp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@NamedQuery(name="fetchByCategoryAuthor", 
            query="from Book b where b.category=?1 and b.author=?2")
@NamedQueries(value = {
		@NamedQuery(name="findByAuth",query="from Book b where b.author=?1"),
		@NamedQuery(name="findByCat",query="from Book b where b.category=?1")
})

@NamedNativeQuery(name="fetchAll", query="select * from book")

//@Table(name = "BookDetails") //book_details to give a differnt table name
public class Book {
	@Column(length = 30)
	private String title;
	@Id // represents the primary key
	@GeneratedValue
	private Integer bookId;
	@Column(name = "cost")
	private double price;
	@Column(length = 30)
	private String author;
	@Column(length = 30)
	private String category;
	private LocalDate datePublished;
	
	

}









