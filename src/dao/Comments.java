package dao;

import java.sql.Timestamp;

public class Comments {
	private String comment;
	private String blog_id;
	private String user_name;
	private Timestamp date;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Comments(String comment, String user_name, Timestamp date) {
		super();
		this.comment = comment;
		this.user_name = user_name;
		this.date = date;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
