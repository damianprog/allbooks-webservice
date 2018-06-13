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
@Table(name = "pending")
public class Pending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "recipent_id")
	private Reader recipent;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private Reader sender;

	public Pending() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Reader getRecipent() {
		return recipent;
	}

	public void setRecipent(Reader recipent) {
		this.recipent = recipent;
	}

	public Reader getSender() {
		return sender;
	}

	public void setSender(Reader sender) {
		this.sender = sender;
	}

}
