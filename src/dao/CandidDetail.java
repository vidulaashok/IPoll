package dao;

public class CandidDetail {
	private String name;
	private String address;
	private String emailId;
	private String party;
	private String uniqueId;
	
	public void setName(String name){
		this.name = name;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setEmailId(String emailId){
		this.emailId = emailId;
	}
	public void setParty(String party){
		this.party= party;
	}
	public void setUniqueId(String uniqueId){
		this.uniqueId = uniqueId;
	}
	public String getName(){
		return this.name;
	}
	public String getParty(){
		return this.party;
	}
	public String getUniqueId(){
		return this.uniqueId;
	}
	public String getEmailId(){
		return this.emailId;
	}
	public String getAddress(){
		return this.address;
	}
	public CandidDetail(){
		
	}
	public CandidDetail(String name, String address,
			String emailId, String party,
			String uniqueId){
		this.name = name;
		this.address= address;
		this.emailId= emailId;
		this.party = party;
		this.uniqueId= uniqueId;
	}
}
