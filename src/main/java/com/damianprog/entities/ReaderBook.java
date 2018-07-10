package com.damianprog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "readerbook")
public class ReaderBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id")
	private Book book;

	@Lob
	@Column(name = "book_pic")
	private byte[] bookPic;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reader_rating_id")
	private Rating readerRating;

	@ManyToOne
	@JoinColumn(name = "reader_id")
	private Reader reader;

	@Enumerated(EnumType.STRING)
	@Column(name = "shelves_states")
	private ShelvesStates shelvesStates;

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

	public Rating getReaderRating() {
		return readerRating;
	}

	public void setReaderRating(Rating readerRating) {
		this.readerRating = readerRating;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public ShelvesStates getShelvesStates() {
		return shelvesStates;
	}

	public void setShelvesStates(ShelvesStates shelvesStates) {
		this.shelvesStates = shelvesStates;
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

}
