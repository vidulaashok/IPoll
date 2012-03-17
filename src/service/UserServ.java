package service;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.User;
import dao.UserDAO;
import dao.WardUser;
import dao.WardUserDAO;

public class UserServ {
	private UserDAO dao;
	private User user;
	private WardUserDAO wudao;
	
	public void setSession(SessionFactory sessionFactory)
	{
		if(dao==null)
			dao = new UserDAO();
		dao.setSessionFactory(sessionFactory);
	}
	/**
	 * @return the dao
	 */
	public UserDAO getDao() {
		return dao;
	}
	/**
	 * @param dao the dao to set
	 */
	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	public void updateUser(User user,SessionFactory sessionFactory)
	{
		if(dao != null)
			dao = new UserDAO();
		if(dao.getSessionFactory()!=null)
			dao.setSessionFactory(sessionFactory);
		dao.updateUser(user);
	}
	
	public void updateUser(User user)
	{
		if(dao!=null&&dao.getSessionFactory()!=null)
			dao.updateUser(user);
	}
	
	public void logOffUser(User user,SessionFactory sessionFactory)
	{
		dao = new UserDAO();
		dao.setSessionFactory(sessionFactory);
		user.setLastLogin(new Timestamp(new Date().getTime()));
		dao.updateUser(user);
	}
	public boolean isValidUser(String id,String password)
	{
		user = dao.getUser(id);
		if(user!=null)
		{
			if(user.getPassword().equals(password)&&user.getValidity()!=0)
			{
				
				return true;
			}
		}
		return false;
	}
	public boolean isUser(String id,SessionFactory obj)
	{
		dao = new UserDAO();
		dao.setSessionFactory(obj);
		if(dao.getUser(id)!=null)
		{
			
			return true;
		}
		
		return false;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean writeUser(User newUser)
	{
		if(newUser!=null)
		{
			return dao.persistUser(newUser);
		}
		return false;
	}
	public WardUser getWardUser(String id)
	{
		if(wudao!=null)
			return wudao.getWardUser(id);
		return null;
	}
	public WardUserDAO getWudao() {
		return wudao;
	}
	public void setWudao(WardUserDAO wudao) {
		this.wudao = wudao;
	}
}