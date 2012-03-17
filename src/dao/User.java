package dao;

import java.sql.Timestamp;

public class User {
	private String id;
	private String password;
	private String type;
	private String language;
	private Timestamp createdOn;
	private Timestamp lastLogin;
	private String email;
	private Integer validity;
	
	
	/**
	 * @return the validity
	 */
	public Integer getValidity() {
		return validity;
	}
	/**
	 * @param validity the validity to set
	 */
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	/**
	 * @return the id
	 */
	public User()
	{
		
	}
	public String getId() {
		return id;
	}
	public User(String id, String password, String type, String language,
			Timestamp createdOn, Timestamp lastLogin, String email) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
		this.language = language;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.email = email;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the createdOn
	 */
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the lastLogin
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}
