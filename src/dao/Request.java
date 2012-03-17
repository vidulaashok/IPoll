package dao;

import java.sql.Timestamp;
import java.util.Date;

public class Request {
	long reqid;
	String reqtype;
	String reqquestion;
	String reqstatus;
	Timestamp reqTime;
	Timestamp reqServ;
	String id;
	
	
	public Request(String reqtype, String reqquestion, String reqstatus,
			Timestamp reqTime, Timestamp reqServ, String id) {
		super();
		this.reqtype = reqtype;
		this.reqquestion = reqquestion;
		this.reqstatus = reqstatus;
		this.reqTime = reqTime;
		this.reqServ = reqServ;
		this.id = id;
	}
	public Request() {
		super();
	}
	/**
	 * @return the reqid
	 */
	public long getReqid() {
		return reqid;
	}
	/**
	 * @param reqid the reqid to set
	 */
	public void setReqid(long reqid) {
		this.reqid = reqid;
	}
	/**
	 * @return the reqtype
	 */
	public String getReqtype() {
		return reqtype;
	}
	/**
	 * @param reqtype the reqtype to set
	 */
	public void setReqtype(String reqtype) {
		this.reqtype = reqtype;
	}
	/**
	 * @return the reqquestion
	 */
	public String getReqquestion() {
		return reqquestion;
	}
	/**
	 * @param reqquestion the reqquestion to set
	 */
	public void setReqquestion(String reqquestion) {
		this.reqquestion = reqquestion;
	}
	/**
	 * @return the reqstatus
	 */
	public String getReqstatus() {
		return reqstatus;
	}
	/**
	 * @param reqstatus the reqstatus to set
	 */
	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
	}
	/**
	 * @return the reqTime
	 */
	public Timestamp getReqTime() {
		return reqTime;
	}
	/**
	 * @param reqTime the reqTime to set
	 */
	public void setReqTime(Timestamp reqTime) {
		this.reqTime = reqTime;
	}
	/**
	 * @return the reqServ
	 */
	public Timestamp getReqServ() {
		return reqServ;
	}
	/**
	 * @param reqServ the reqServ to set
	 */
	public void setReqServ(Timestamp reqServ) {
		this.reqServ = reqServ;
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
	
}
