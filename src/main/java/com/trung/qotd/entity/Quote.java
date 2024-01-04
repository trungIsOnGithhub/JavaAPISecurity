package com.trung.qotd.entity;

public class Quote extends MyEntity {
	private String title;
	private String body;
	
	private String contributor;
	
	public Quote(String title, String body, String contributor) {
		this.title = title;
		this.body = body;
		this.contributor = contributor;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getContributor() {
		return contributor;
	}
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	
	@Override
	public String toString() {
		return this.body;
	}
}
