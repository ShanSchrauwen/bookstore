package com.haagahelia.model;
import javax.persistence.*;

/*
 Issues faced
 
 Entity did not work due to persistence not being imported.
 Had to add javax.persistence manually to pom.xml
 
 <dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>

From https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api/2.2
 */

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	public Book() {}
	
	public Book(String title, String author, int year, String isbn, double price) {
		this.title = title;
		this.author=author;
		this.year=year;
		this.isbn=isbn;
		this.price=price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book: " + isbn + " - " + title + ", " + author + ", published " + year + " (" + price + ")";
	}
}
