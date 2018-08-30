package com.damianprog.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Indexed
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Lob
	@Column(name = "book_photo")
	private byte[] bookPhoto;

	@Column(name = "mini_title")
	private String miniTitle;

	@Column(name = "full_title")
	@Field
	private String fullTitle;

	@Column(name = "author")
	private String author;

	@Column(name = "about_author")
	private String aboutAuthor;

	@Lob
	@Column(name = "author_photo")
	private byte[] authorPhoto;

	@Column(name = "review_author")
	private String reviewAuthor;

	@Column(name = "description")
	private String description;

	@Column(name = "book_quotes")
	private String bookQuotes;

	@Column(name = "cover_type")
	private String coverType;

	@Column(name = "pages")
	private int pages;

	@Column(name = "publish_date")
	private Date publishDate;

	@Column(name = "publish_company")
	private String publishCompany;

	@Column(name = "buy_book")
	private String buyBook;

	@Column(name = "category")
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMiniTitle() {
		return miniTitle;
	}

	public void setMiniTitle(String miniTitle) {
		this.miniTitle = miniTitle;
	}

	public byte[] getBookPhoto() {
		return bookPhoto;
	}

	public void setBookPhoto(byte[] bookPhoto) {
		this.bookPhoto = bookPhoto;
	}

	public String getAboutAuthor() {
		return aboutAuthor;
	}

	public void setAboutAuthor(String aboutAuthor) {
		this.aboutAuthor = aboutAuthor;
	}

	public byte[] getAuthorPhoto() {
		return authorPhoto;
	}

	public void setAuthorPhoto(byte[] authorPhoto) {
		this.authorPhoto = authorPhoto;
	}

	public String getReviewAuthor() {
		return reviewAuthor;
	}

	public void setReviewAuthor(String reviewAuthor) {
		this.reviewAuthor = reviewAuthor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookQuotes() {
		return bookQuotes;
	}

	public void setBookQuotes(String bookQuotes) {
		this.bookQuotes = bookQuotes;
	}

	public String getCoverType() {
		return coverType;
	}

	public void setCoverType(String coverType) {
		this.coverType = coverType;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishCompany() {
		return publishCompany;
	}

	public void setPublishCompany(String publishCompany) {
		this.publishCompany = publishCompany;
	}

	public String getBuyBook() {
		return buyBook;
	}

	public void setBuyBook(String buyBook) {
		this.buyBook = buyBook;
	}

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

}
