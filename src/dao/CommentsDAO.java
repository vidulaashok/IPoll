package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CommentsDAO extends BaseHibernate{
	public Comments getComments(String user_name)
	{
		Comments com = null;
		Session session=null;
		Criteria constraint=null;
		try
		{
			session = getSessionFactory().openSession();
			constraint=session.createCriteria(Comments.class);
			constraint.add(Restrictions.idEq(user_name));
			if(constraint.list().size()>0)
			{
				com = (Comments) constraint.list().get(0);
			}
		}catch(HibernateException e)
		{
			System.out.println("Error:Hibernate Exception\nFileName: CommentsDAO Method:getComment()");
			e.printStackTrace();
		}catch(ClassCastException c)
		{
			System.out.println("Error:Hibernate Configuration in Comments.hbm.xml");
		}finally
		{
			if(session!=null)
			session.close();
		}
		
	
		return com;
	}
	public boolean updateComment(Comments com)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(com);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:CommentsDAO method:updateComment ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public boolean persistComments(Comments com)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(com);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:CommentsDAO method:persistComment ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	

	

}
