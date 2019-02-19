package com.jacob.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Blog {
	int id; 
    @JsonProperty("title")
	String title; 
    @JsonProperty("content")
	String content;
	
	public Blog(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	
	public Blog(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public Blog() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 


}
