package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CandidateDAO extends BaseHibernate{
	public Candidate getCandidate(String user_name)
	{
		Candidate cand = null;
		Session session=null;
		Criteria constraint=null;
		try
		{
			session = getSessionFactory().openSession();
			constraint=session.createCriteria(Comments.class);
			constraint.add(Restrictions.idEq(user_name));
			if(constraint.list().size()>0)
			{
				cand = (Candidate) constraint.list().get(0);
			}
		}catch(HibernateException e)
		{
			System.out.println("Error:Hibernate Exception\nFileName: CandiateDAO Method:getCandidate()");
			e.printStackTrace();
		}catch(ClassCastException c)
		{
			System.out.println("Error:Hibernate Configuration in Candidate.hbm.xml");
		}finally
		{
			if(session!=null)
			session.close();
		}
		
	
		return cand;
	}
	public boolean updateCandidate(Candidate cand)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(cand);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:CandidateDAO method:updateCandidate ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public boolean persistcandidate(Candidate cand)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(cand);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:CandidateDAO method:persistCandidate ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	

	

}