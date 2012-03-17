package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserDAO extends BaseHibernate{
	
	public User getUser(String id)
	{
		User user;
		Session session = null;
		user=null;
		Criteria constraint;	
		try
		{
			session = getSessionFactory().openSession();
			constraint=session.createCriteria(User.class);
			constraint.add(Restrictions.idEq(id));
			if(constraint.list().size()>0)
			{
				user = (User) constraint.list().get(0);
			}
		}catch(HibernateException e)
		{
			System.out.println("Error:Hibernate Exception\nFileName: UserDAO Method:getUser()");
			e.printStackTrace();
		}catch(ClassCastException c)
		{
			System.out.println("Error:Hibernate Configuration in User.hbm.xml");
		}finally
		{
			if(session!=null)
			session.close();
		}
		return user;
	}
	
	public boolean updateUser(User user)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(user);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:UserDAO method:persistUser ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public boolean persistUser(User user)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(user);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:UserDAO method:persistUser ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
}
