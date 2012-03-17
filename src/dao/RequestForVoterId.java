package dao;

public class RequestForVoterId {
	Long reqid;
	String voterid;
	/**
	 * @return the reqid
	 */
	public Long getReqid() {
		return reqid;
	}
	/**
	 * @param reqid the reqid to set
	 */
	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}
	/**
	 * @return the voterid
	 */
	public String getVoterid() {
		return voterid;
	}
	/**
	 * @param voterid the voterid to set
	 */
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	public RequestForVoterId(Long reqid, String voterid) {
		super();
		this.reqid = reqid;
		this.voterid = voterid;
	}
	public RequestForVoterId() {
		super();
	}
	
}
