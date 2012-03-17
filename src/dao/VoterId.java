package dao;

import java.sql.Timestamp;
import java.util.Date;

import sun.util.resources.CalendarData;

public class VoterId {
	public static int NOTVALIDATED = 0;
	public static int ACCEPTED = 2;
	public static int REJECTED = 3;
	String id;
	String name;
	String surName;
	String fathersName;
	String sex;
	Timestamp dateOfBirth;
	String placeOfBirth;
	String currentAddress;
	String currentAddressState;
	String currentAddressCityTown;
	String currentAddressWardNo;
	String voterID;
	/**
	 * @param wardId the wardId to set
	 */
	public void setWardId(long wardId) {
		this.wardId = wardId;
	}
	Timestamp effectiveFrom;
	String imageFileId;
	String validatedBy;
	String relID;
	long wardId;
	Integer validity;
	
	
	public VoterId(String id, String name, String surName, String fathersName,
			String sex, Timestamp dateOfBirth, String placeOfBirth,
			String currentAddress, String currentAddressState,
			String currentAddressCityTown, String currentAddressWardNo,
			 Timestamp effectiveFrom, String imageFileId,
			String validatedBy, String relID, long wardId, Integer validity) {
		
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.fathersName = fathersName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.currentAddress = currentAddress;
		this.currentAddressState = currentAddressState;
		this.currentAddressCityTown = currentAddressCityTown;
		this.currentAddressWardNo = currentAddressWardNo;
		this.effectiveFrom = effectiveFrom;
		this.imageFileId = imageFileId;
		this.validatedBy = validatedBy;
		this.relID = relID;
		this.wardId = wardId;
		this.validity = validity;
	}
	public VoterId() {
		
	}
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
	/**
	 * @return the currentAddress
	 */
	public String getCurrentAddress() {
		return currentAddress;
	}
	/**
	 * @param currentAddress the currentAddress to set
	 */
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	/**
	 * @return the currentAddressState
	 */
	public String getCurrentAddressState() {
		return currentAddressState;
	}
	/**
	 * @param currentAddressState the currentAddressState to set
	 */
	public void setCurrentAddressState(String currentAddressState) {
		this.currentAddressState = currentAddressState;
	}
	/**
	 * @return the currentAddressCityTown
	 */
	public String getCurrentAddressCityTown() {
		return currentAddressCityTown;
	}
	/**
	 * @param currentAddressCityTown the currentAddressCityTown to set
	 */
	public void setCurrentAddressCityTown(String currentAddressCityTown) {
		this.currentAddressCityTown = currentAddressCityTown;
	}
	/**
	 * @return the currentAddressWardNo
	 */
	public String getCurrentAddressWardNo() {
		return currentAddressWardNo;
	}
	/**
	 * @param currentAddressWardNo the currentAddressWardNo to set
	 */
	public void setCurrentAddressWardNo(String currentAddressWardNo) {
		this.currentAddressWardNo = currentAddressWardNo;
	}
	
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Timestamp getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(Timestamp effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the fathersName
	 */
	public String getFathersName() {
		return fathersName;
	}
	/**
	 * @param fathersName the fathersName to set
	 */
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	/**
	 * @return the voterID
	 */
	public String getVoterID() {
		return voterID;
	}
	/**
	 * @param voterID the voterID to set
	 */
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	/**
	 * @return the effectiveFrom
	 */
	public Timestamp getEffectiveFrom() {
		return effectiveFrom;
	}
	/**
	 * @return the imageFileId
	 */
	public String getImageFileId() {
		return imageFileId;
	}
	/**
	 * @param imageFileId the imageFileId to set
	 */
	public void setImageFileId(String imageFileId) {
		this.imageFileId = imageFileId;
	}
	/**
	 * @return the validatedBy
	 */
	public String getValidatedBy() {
		return validatedBy;
	}
	/**
	 * @param validatedBy the validatedBy to set
	 */
	public void setValidatedBy(String validatedBy) {
		this.validatedBy = validatedBy;
	}
	/**
	 * @return the relID
	 */
	public String getRelID() {
		return relID;
	}
	/**
	 * @param relID the relID to set
	 */
	public void setRelID(String relID) {
		this.relID = relID;
	}
	
	
}
