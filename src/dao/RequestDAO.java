package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class RequestDAO extends BaseHibernate {
	public boolean writeReq(Request req)
	{
		Session session=null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(req);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			System.err.println("Error: at ReqDAO function: createRequest()");
			if(trans!=null)
				trans.rollback();
		}finally
		{
			if(session!=null)
				session.close();
		}
		return false;
	}
	
	public Request getRequest(Long reqid)
	{
		Request req = null;
		Session session = null;
		Criteria ctr = null;
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(Request.class);
			ctr.add(Restrictions.idEq(reqid));
			if(ctr.list().size()>0)
				req = (Request) ctr.list().get(0);
		}catch(HibernateException e)
		{
			e.printStackTrace();
			System.err.println("Error: reqDAO method: getRequest()");
		}finally
		{
			if(session!=null)
				session.close();
		}
		return req;
	}
}
