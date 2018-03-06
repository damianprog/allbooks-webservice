package com.damianprog.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "text")
	private String text;

	@Column(name = "title")
	private String title;

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "likes")
	private int likes;

	@Column(name = "readerLogin")
	private String readerLogin;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "reader_id")
	@JsonBackReference
	private Reader reader;

	@Column(name = "reader_identity")
	private int readerIdentity;

	@Column(name = "readerRating")
	private int readerRating;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "review_id")
	private List<Comment> comments;

	@Column(name = "bookId")
	private int bookId;

	public Review() {
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getReaderIdentity() {
		return readerIdentity;
	}

	public void setReaderIdentity(int readerIdentity) {
		this.readerIdentity = readerIdentity;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReaderLogin() {
		return readerLogin;
	}

	public void setReaderLogin(String readerLogin) {
		this.readerLogin = readerLogin;
	}

	public int getReaderRating() {
		return readerRating;
	}

	public void setReaderRating(int readerRating) {
		this.readerRating = readerRating;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
