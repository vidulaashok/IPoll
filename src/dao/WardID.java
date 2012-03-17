package dao;

public class WardID {
	String state;
	String city;
	String wardNo;
	long wardId;
	
	public WardID(String state, String city, String wardNo) {
		super();
		this.state = state;
		this.city = city;
		this.wardNo = wardNo;
	}
	public WardID() {
		super();
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the wardNo
	 */
	public String getWardNo() {
		return wardNo;
	}
	/**
	 * @param wardNo the wardNo to set
	 */
	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}
	/**
	 * @return the wardId
	 */
	public long getWardId() {
		return wardId;
	}
	/**
	 * @param wardId the wardId to set
	 */
	public void setWardId(long wardId) {
		this.wardId = wardId;
	}
	
}
