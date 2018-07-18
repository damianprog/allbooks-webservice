package com.damianprog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "reading_challange_comment")
public class ReadingChallangeComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "text")
	private String text;

	@ManyToOne
	@JoinColumn(name = "posting_reader_id")
	private Reader postingReader;

	@ManyToOne
	@JoinColumn(name = "challange_reader_id")
	private Reader challangeReader;

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

	public Reader getPostingReader() {
		return postingReader;
	}

	public void setPostingReader(Reader postingReader) {
		this.postingReader = postingReader;
	}

	public Reader getChallangeReader() {
		return challangeReader;
	}

	public void setChallangeReader(Reader challangeReader) {
		this.challangeReader = challangeReader;
	}

}
