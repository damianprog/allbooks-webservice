package com.damianprog.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "readerbook")
public class ReaderBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "bookId")
	private int bookId;

	@Column(name = "minbook_name")
	private String minBookName;

	@Column(name = "fullbook_name")
	private String fullBookName;

	@Lob
	@Column(name = "book_pic")
	private byte[] bookPic;

	@Column(name = "author")
	private String author;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reader_id")
	@JsonBackReference
	private Reader reader;

	@Column(name = "shelves")
	private String shelves;

	@Column(name = "date_read")
	private String dateRead;

	@Column(name = "date_added")
	private String dateAdded;

	public byte[] getBookPic() {
		return bookPic;
	}

	public void setBookPic(byte[] bookPic) {
		this.bookPic = bookPic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

}
