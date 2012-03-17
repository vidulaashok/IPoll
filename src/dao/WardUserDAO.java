package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class WardUserDAO extends BaseHibernate{
	public boolean writeWardUser(WardUser wuser)
	{
		Session session=null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(wuser);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			System.err.println("Error: at WardUserDAO function: writeWardUser()");
			if(trans!=null)
				trans.rollback();
		}finally
		{
			if(session!=null)
				session.close();
		}
		return false;
	}
	public WardUser getWardUser(String user)
	{
		WardUser req = null;
		Session session = null;
		Criteria ctr = null;
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(Request.class);
			ctr.add(Restrictions.idEq(user));
			if(ctr.list().size()>0)
				req = (WardUser) ctr.list().get(0);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			System.err.println("Error: WardUserDAO method: getWardUser()");
		}finally
		{
			if(session!=null)
				session.close();
		}
		return req;
	}
	public WardUser getWardUser(long wardid)
	{
		WardUser req = null;
		Session session = null;
		Criteria ctr = null;
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(WardUser.class);
			ctr.add(Restrictions.eq("wardId", wardid));
			if(ctr.list().size()>0)
				req = (WardUser) ctr.list().get(0);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			System.err.println("Error: WardUserDAO method: getWardUser()");
		}finally
		{
			if(session!=null)
				session.close();
		}
		return req;
	}
}
