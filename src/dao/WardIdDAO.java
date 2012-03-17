package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class WardIdDAO extends BaseHibernate{
	public WardID getWardId(String wardId)
	{
		Session session = null;
		Criteria ctr = null;
		WardID ward =null;
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(WardID.class);
			ctr.add(Restrictions.idEq(wardId));
			if(ctr.list().size()>0)
				ward = (WardID) ctr.list().get(0);
		}catch(HibernateException e)
		{
			System.err.println("Error: WardIdDAO method: getWardId()");
		}finally
		{
			if(session!=null)
				session.close();
		}
		return ward;
	}
	
	public WardID getWardId(String state,String city,String wardno)
	{
		Session session = null;
		Criteria ctr = null;
		WardID ward =null;
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(WardID.class);
			ctr.add(Restrictions.eq("state", state));
			ctr.add(Restrictions.eq("city", city));
			ctr.add(Restrictions.eq("wardNo", wardno));
			if(ctr.list().size()>0)
				ward = (WardID) ctr.list().get(0);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			System.err.println("Error: WardIdDAO method: getWardId()");
		}finally
		{
			if(session!=null)
				session.close();
		}
		return ward;
	}
	
	public boolean writeWardId(WardID ward)
	{
		Session session =null;
		Transaction trans = null;
		try
		{
			if(ward==null)
				return false;
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(ward);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			if(trans!=null)
				trans.rollback();
			System.err.println("Error: FileDAO method: writeFileContent()");
		}
		finally
		{
			if(session!=null)
				session.close();
		}
		return false;
	}
}
