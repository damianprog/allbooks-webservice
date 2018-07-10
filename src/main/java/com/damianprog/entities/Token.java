package com.damianprog.entities;

public abstract class Token {

	private int id;

	private String token;

	private Reader reader;

	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getToken();

	public abstract void setToken(String token);

	public abstract Reader getReader();

	public abstract void setReader(Reader reader);

}
