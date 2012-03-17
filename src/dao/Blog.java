package dao;

import java.sql.Timestamp;

public class Blog {
	private String blog_id;
	private String title;
	private String post;
	private Timestamp date;
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public Blog() {
		super();
	}
	public Blog(String title, String post, Timestamp date) {
		super();
		this.title = title;
		this.post = post;
		this.date = date;
	}
	
	
}
