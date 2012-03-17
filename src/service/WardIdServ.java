package service;

import org.hibernate.SessionFactory;

import dao.WardIdDAO;

public class WardIdServ {
	WardIdDAO dao;
	
	public boolean validity(String state,String city,String wardno,SessionFactory obj)
	{
		if(dao==null)
			dao=new WardIdDAO();
		if(dao.getSessionFactory()==null)
			dao.setSessionFactory(obj);
		if(dao.getWardId(state, city, wardno)!=null)
			return true;
		return false;
	}
}
