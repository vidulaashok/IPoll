package dao;
import java.util.Date;

public class Candidate {
	private String id;
	private String name;
	private String surname;
	private Date dob;
	private String placeOfBirth;
	private String fatherName;
	private Boolean sex;
	private String currAddress;
	private String uniqueId;
	private String voterId;
	private Boolean validity;
	private Date dateOfEffect;
	private String emailId;
	private String representingParty;
	private Boolean partyType;
	private String relId;
	private String partyImage;
	private CandidDetail candidList[];
	
	Candidate(){
		candidList = new CandidDetail[10];
	}
	
	Candidate(String id,	String name,	String surname,	Date dob,
	String placeOfBirth,	String fatherName,	Boolean sex,	String currAddress,
	String uniqueId,	String voterId,		Boolean validity,	Date dateOfEffect,
	String emailId,	String representingParty,
	Boolean partyType,	String relId, String partyImage, CandidDetail candidList[]){
		
		this.currAddress=currAddress;
		this.dateOfEffect=dateOfEffect;
		this.dob=dob;
		this.emailId=emailId;
		this.fatherName =fatherName;
		this.id=id;
		this.name=name;
		this.partyImage=partyImage;
		this.partyType=partyType;
		this.placeOfBirth=placeOfBirth;
		this.relId=relId;
		this.representingParty= representingParty;
		this.sex = sex;
		this.surname=surname;
		this.uniqueId=uniqueId;
		this.validity=validity;
		this.voterId=voterId;
		this.candidList=candidList;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getSurname() {
		return this.surname;
	}
	public Date getDob() {
		return this.dob;
	}
	public String getPlaceOfBirth(){
		return this.placeOfBirth;
	}
	public String getFatherName(){
		return this.fatherName;
	}
	public Boolean getSex(){
		return this.sex;
	}
	public String getCurrAddress(){
		return this.currAddress;
	}
	public Boolean getValidity(){
		return this.validity;
	}
	public Date getDateOfEffect(){
		return this.dateOfEffect;
	}
	public String getEmailId(){
		return this.emailId;
	}
	public String getVoterId(){
		return this.voterId;
	}
	public Boolean getPartyType(){
		return this.partyType;
	}
	public String getRelId(){
		return this.relId;
	}
	public String getRepresentingParty(){
		return this.representingParty;
	}
	public String getPartyImage(){
		return this.partyImage;
	}
	public String getUniqueId(){
		return this.uniqueId;
	}
	public void setName(String Name){
		this.name= Name;
	}
	public void setSurname(String Surname) {
		this.surname=Surname;
	}
	public void setDob(Date Dob) {
		this.dob=Dob;
	}
	public void setPlaceOfBirth(String PlaceOfBirth){
		this.placeOfBirth=PlaceOfBirth;
	}
	public void setFatherName(String FatherName){
		this.fatherName= FatherName;
	}
	public void setSex(Boolean Sex ){
		this.sex=Sex;
	}
	public void getCurrAddress(String CurrAddress){
		this.currAddress=CurrAddress;
	}
	public void setValidity(Boolean Validity){
		this.validity=Validity;
	}
	public void setDateOfEffect(Date DateOfEffect){
		this.dateOfEffect=DateOfEffect;
	}
	public void setEmailId(String EmailId){
		this.emailId= EmailId;
	}
	public void setVoterId(String VoterId){
		this.voterId = VoterId;
	}
	public void setPartyType(Boolean PartyType){
		this.partyType= PartyType;
	}
	public void setRelId(String RelId){
		this.relId = RelId;
	}
	public void setRepresentingParty(String RepresentParty){
		this.representingParty= RepresentParty;
	}
	public void setPartyImage(String PartyImage){
		this.partyImage= PartyImage;
	}
	public void setUniqueId( String UniqueId){
		 this.uniqueId = UniqueId;
	}
	public void setId(String Id){
		this.id=Id;
	}

	public CandidDetail[] getCandidList() {
		return candidList;
	}

	public void setCandidList(CandidDetail[] candidList) {
		this.candidList = candidList;
	}

	public void setCurrAddress(String currAddress) {
		this.currAddress = currAddress;
	}

}