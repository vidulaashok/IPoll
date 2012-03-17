package service;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import dao.FileContent;
import dao.FileDAO;
import dao.FileInfo;
import dao.RequestDAO;
import dao.Request;
import dao.RequestForVoterId;
import dao.RequestForVoterIdDAO;
import dao.VoterId;
import dao.VoterIdDAO;
import dao.WardID;
import dao.WardIdDAO;
import dao.WardUser;

public class VoterIdServ {
	VoterIdDAO dao;
	RequestForVoterIdDAO rdao;
	VoterId voterid;
	FileInfo file;
	FileContent content;
	WardID wardid;
	Request request;
	RequestForVoterId req4voterid;
	WardUser warduser;
	
	
	
	public RequestForVoterId getReq4voterid() {
		return req4voterid;
	}

	public void setReq4voterid(RequestForVoterId req4voterid) {
		this.req4voterid = req4voterid;
	}

	public RequestForVoterIdDAO getRdao() {
		return rdao;
	}

	public void setRdao(RequestForVoterIdDAO rdao) {
		this.rdao = rdao;
	}

	public boolean isRequestForVoterId(long reqid)
	{
		req4voterid = rdao.getRequestForVoterId(reqid);
		if(req4voterid!=null)
			return true;
		return false;
	}

	/**
	 * @return the dao
	 */
	public VoterIdDAO getDao() {
		return dao;
	}



	/**
	 * @param dao the dao to set
	 */
	public void setDao(VoterIdDAO dao) {
		this.dao = dao;
	}



	public boolean writeVoterId(String name,String surName,String currAdd,String currState,String currCity,
			String currWardNo,Timestamp dob,Blob userImage,String pobAdd,String id,String fathersName,String sex,
			String relId,String userImageContentType,String userImageFileName)
	{
		if(dao.getVoterIdByUser(id)==null)
		{
		file = new FileInfo(userImageFileName,userImageContentType,id);
		content = new FileContent(null,userImage);
		wardid = new WardID(currState,currCity,currWardNo);
		voterid = new VoterId(id,name,surName,fathersName,sex,dob,pobAdd,currAdd,currState,currCity,currWardNo,null,
		null,null,relId,wardid.getWardId(),VoterId.NOTVALIDATED);
		request = new Request("voterid","Verify the details of the voterId: ","unverified",new Timestamp(new Date().getTime()),null,null);
		req4voterid = new RequestForVoterId(null,null);
		warduser = new WardUser(null,null);
		if(dao.writeVoterId(voterid, wardid, content, file, request, req4voterid, warduser))
			return true;
		}
		return false;
	}
	
	public boolean isWardID(String state,String city,String wardNo)
	{
		if(dao!=null)
			if(dao.getWardId(state, city, wardNo)!=null)
				return true;
		return false;
	}
	
	public boolean getVoterId(String voterid)
	{
		if(dao!=null)
		{
			this.voterid = dao.getVoterId(voterid);
			return true;
		}
		return false;
	}
	
	public boolean getVoterIdByUser(String id)
	{
			this.voterid = dao.getVoterIdByUser(id);
			if(voterid!=null)
				return true;
		return false;
	}
	
	public VoterId getVoterIdObject()
	{
		return voterid;
	}
}
