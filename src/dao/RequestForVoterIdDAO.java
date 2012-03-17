package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class RequestForVoterIdDAO extends BaseHibernate {
	public boolean writeRequestForVoterId(RequestForVoterId req4voterid)
	{
		Session session=null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(req4voterid);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			System.err.println("Error: at ReqForVoterIdDAO function: createReqForVoterId()");
			if(trans!=null)
				trans.rollback();
		}finally
		{
			if(session!=null)
				session.close();
		}
		return false;
	}
	public RequestForVoterId getRequestForVoterId(Long reqid)
	{
		Session session = null;
		RequestForVoterId req4voterid = null;
		Criteria ctr;
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(RequestForVoterId.class);
			ctr.add(Restrictions.idEq(reqid));
			if(ctr.list().size()>0)
				req4voterid = (RequestForVoterId) ctr.list().get(0); 
		}catch(HibernateException e)
		{
			System.err.println("Error: file: ReqForVoterIdDAO method: getReqForVoterId()");
		}
		return req4voterid;
	}
	public HashMap<Request,RequestForVoterId> getRequestForVoterIdWardUser(String id)
	{
		Session session = null;
		RequestForVoterId req4voterid = null;
		Criteria ctr;
		HashMap<Request,RequestForVoterId> hm = new HashMap<Request,RequestForVoterId>();
		try
		{
			session = getSessionFactory().openSession();
			ctr = session.createCriteria(Request.class);
			ctr.add(Restrictions.eq("id",id));
			ctr.add(Restrictions.eq("reqstatus","unverified"));
			if(ctr.list().size()>0)
			{
				Iterator<Request> it = ctr.list().iterator();
				
				while(it.hasNext())
				{
					Request r = it.next();
					Criteria ct = session.createCriteria(RequestForVoterId.class);
					ct.add(Restrictions.eq("reqid", r.getReqid()));
					hm.put(r,(RequestForVoterId)ct.uniqueResult());
				}
			} 
		}catch(HibernateException e)
		{
			System.err.println("Error: file: ReqForVoterIdDAO method: getReqForVoterId()");
		}
		
		return hm;
	} 
}
