package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PartyDAO extends BaseHibernate{
	
	public Party getParty(String user_name)
	{
		Party par = null;
		Session session=null;
		Criteria constraint=null;
		try
		{
			session = getSessionFactory().openSession();
			constraint=session.createCriteria(Comments.class);
			constraint.add(Restrictions.idEq(user_name));
			if(constraint.list().size()>0)
			{
				par = (Party) constraint.list().get(0);
			}
		}catch(HibernateException e)
		{
			System.out.println("Error:Hibernate Exception\nFileName: PartyDAO Method:getParty()");
			e.printStackTrace();
		}catch(ClassCastException c)
		{
			System.out.println("Error:Hibernate Configuration in Party.hbm.xml");
		}finally
		{
			if(session!=null)
			session.close();
		}
		
	
		return par;
	}
	public boolean updateParty(Party par)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(par);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:PartyDAO method:updateParty ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public boolean persistParty(Party par)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(par);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:PartyDAO method:persistparty ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	

	

}


