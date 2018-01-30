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
	
	@Column(name="reader1")
	private int reader1;
	
	@Column(name="reader2")
	private int reader2;

	@Column(name="reader1_login")
	private String reader1Login;
	
	@Column(name="reader2_login")
	private String reader2Login;
	
	@Column(name="accept")
	private String accept;
	
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

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getReader1Login() {
		return reader1Login;
	}

	public void setReader1Login(String reader1Login) {
		this.reader1Login = reader1Login;
	}

	public String getReader2Login() {
		return reader2Login;
	}

	public void setReader2Login(String reader2Login) {
		this.reader2Login = reader2Login;
	}
}
