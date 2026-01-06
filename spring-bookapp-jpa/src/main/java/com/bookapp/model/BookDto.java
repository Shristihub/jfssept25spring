package com.bookapp.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
	private String title;
	private Integer bookId;
	private double price;
	private String author;
	private String category;
	private LocalDate datePublished;

	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDto(String title, Integer bookId, double price, String author, String category, LocalDate datePublished) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.price = price;
		this.author = author;
		this.category = category;
		this.datePublished = datePublished;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", bookId=" + bookId + ", price=" + price + ", author=" + author + ", category="
				+ category + ", datePublished=" + datePublished + "]";
	}
	
}









