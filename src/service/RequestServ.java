package service;
import java.util.HashMap;

import dao.Request;
import dao.RequestDAO;
import dao.RequestForVoterIdDAO;
public class RequestServ {
	RequestDAO dao;
	RequestForVoterIdDAO rfvdao;
	
	public RequestDAO getDao() {
		return dao;
	}

	public void setDao(RequestDAO dao) {
		this.dao = dao;
	}

	public RequestForVoterIdDAO getRfvdao() {
		return rfvdao;
	}

	public void setRfvdao(RequestForVoterIdDAO rfvdao) {
		this.rfvdao = rfvdao;
	}

	public HashMap<Request, dao.RequestForVoterId> getRequestForVoterIdWardUser(String id)
	{
		if(rfvdao!=null)
			return rfvdao.getRequestForVoterIdWardUser(id);
		return null;
	}
	
}
