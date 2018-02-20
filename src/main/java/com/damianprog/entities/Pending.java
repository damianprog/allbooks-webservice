package com.damianprog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "pending")
public class Pending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "recipent_id")
	private int recipentId;

	@Column(name = "sender_id")
	private int senderId;

	@Column(name = "recipent_login")
	private String recipentLogin;

	@Column(name = "sender_login")
	private String senderLogin;

	public Pending() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipentId() {
		return recipentId;
	}

	public void setRecipentId(int recipentId) {
		this.recipentId = recipentId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getRecipentLogin() {
		return recipentLogin;
	}

	public void setRecipentLogin(String recipentLogin) {
		this.recipentLogin = recipentLogin;
	}

	public String getSenderLogin() {
		return senderLogin;
	}

	public void setSenderLogin(String senderLogin) {
		this.senderLogin = senderLogin;
	}

}
