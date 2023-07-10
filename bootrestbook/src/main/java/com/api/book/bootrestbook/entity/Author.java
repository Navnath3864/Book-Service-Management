package com.api.book.bootrestbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
//@Table(name="Author")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	
	private int authorId;
	private String firstName;
	private String lastName;
	private String language;

	public int getAurthorId() {
		return authorId;
	}
	public void setAurthorId(int aurthorId) {
		this.authorId = aurthorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
