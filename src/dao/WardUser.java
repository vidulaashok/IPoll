package dao;

public class WardUser {
	String id;
	Long wardId;
	
	public WardUser() {
		super();
	}
	public WardUser(String id, Long wardId) {
		super();
		this.id = id;
		this.wardId = wardId;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the wardId
	 */
	public Long getWardId() {
		return wardId;
	}
	/**
	 * @param wardId the wardId to set
	 */
	public void setWardId(Long wardId) {
		this.wardId = wardId;
	}
	
}
