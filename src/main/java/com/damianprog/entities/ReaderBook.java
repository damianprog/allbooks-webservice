package com.damianprog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="readerbook")
public class ReaderBook {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="bookId")
	private int bookId;
	
	@Column(name="minbook_name")
	private String minBookName;
	
	@Column(name="fullbook_name")
	private String fullBookName;
	
	@Column(name="author")
	private String author;
	
	@Column(name="rating")
	private double rating;
	
	@Transient
	private int readerRating;
	
	@Column(name="reader_id")
	private int readerId;
	
	@Column(name="shelves")
	private String shelves;
	
	@Column(name="date_read")
	private String dateRead;
	
	@Column(name="date_added")
	private String dateAdded;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getShelves() {
		return shelves;
	}

	public void setShelves(String shelves) {
		this.shelves = shelves;
	}

	public String getDateRead() {
		return dateRead;
	}

	public void setDateRead(String dateRead) {
		this.dateRead = dateRead;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getMinBookName() {
		return minBookName;
	}

	public void setMinBookName(String minBookName) {
		this.minBookName = minBookName;
	}

	public String getFullBookName() {
		return fullBookName;
	}

	public void setFullBookName(String fullBookName) {
		this.fullBookName = fullBookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getReaderRating() {
		return readerRating;
	}

	public void setReaderRating(int readerRating) {
		this.readerRating = readerRating;
	}
	
}
