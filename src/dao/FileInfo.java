package dao;

public class FileInfo {
	String fileId;
	String fileName;
	String disc;
	String uploadedBy;
	
	
	public FileInfo(String fileName, String disc, String uploadedBy) {
		super();
		this.fileName = fileName;
		this.disc = disc;
		this.uploadedBy = uploadedBy;
	}
	public FileInfo() {
		
	}
	/**
	 * @return the fileId
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the disc
	 */
	public String getDisc() {
		return disc;
	}
	/**
	 * @param disc the disc to set
	 */
	public void setDisc(String disc) {
		this.disc = disc;
	}
	/**
	 * @return the uploadedBy
	 */
	public String getUploadedBy() {
		return uploadedBy;
	}
	/**
	 * @param uploadedBy the uploadedBy to set
	 */
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	
}
