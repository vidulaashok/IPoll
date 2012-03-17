package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class LikesDAO extends BaseHibernate{
	public Likes getLikes(String user_name)
	{
		Likes li = null;
		Session session=null;
		Criteria constraint=null;
		try
		{
			session = getSessionFactory().openSession();
			constraint=session.createCriteria(Comments.class);
			constraint.add(Restrictions.idEq(user_name));
			if(constraint.list().size()>0)
			{
				li = (Likes) constraint.list().get(0);
			}
		}catch(HibernateException e)
		{
			System.out.println("Error:Hibernate Exception\nFileName: LikesDAO Method:getLikes()");
			e.printStackTrace();
		}catch(ClassCastException c)
		{
			System.out.println("Error:Hibernate Configuration in Likes.hbm.xml");
		}finally
		{
			if(session!=null)
			session.close();
		}
		
	
		return li;
	}
	public boolean updateComment(Likes li)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(li);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:LikesDAO method:updateLike ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public boolean persistLikes(Likes li)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(li);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:LikesDAO method:persistLikes ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	

	

}
