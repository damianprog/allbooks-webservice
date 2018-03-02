package com.damianprog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="friends")
public class Friends {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="reader_1")
	private int reader1;
	
	@Column(name="reader_2")
	private int reader2;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReader1() {
		return reader1;
	}

	public void setReader1(int reader1) {
		this.reader1 = reader1;
	}

	public int getReader2() {
		return reader2;
	}

	public void setReader2(int reader2) {
		this.reader2 = reader2;
	}
}
