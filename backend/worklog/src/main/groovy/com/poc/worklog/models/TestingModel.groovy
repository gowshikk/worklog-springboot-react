package com.poc.worklog.models

import org.springframework.data.mongodb.core.mapping.Document

@Document
class TestingModel {

//	private int id;
	private String name;
	private String book;
	
	public TestingModel(String name, String book) {
		super();
		this.name = name;
		this.book = book;
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "TestingModel [id=" + id + ", name=" + name + ", book=" + book + "]";
	}
	
	
	
}
