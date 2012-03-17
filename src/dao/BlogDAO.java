package dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BlogDAO extends BaseHibernate{
	public Blog getBlog(String blog_id)
	{
		Blog b = null;
		Session session=null;
		Criteria constraint=null;
		try
		{
			session = getSessionFactory().openSession();
			constraint=session.createCriteria(Blog.class);
			constraint.add(Restrictions.idEq(blog_id));
			if(constraint.list().size()>0)
			{
				b = (Blog) constraint.list().get(0);
			}
		}catch(HibernateException e)
		{
			System.out.println("Error:Hibernate Exception\nFileName: BlogDAO Method:getBlog()");
			e.printStackTrace();
		}catch(ClassCastException c)
		{
			System.out.println("Error:Hibernate Configuration in Blog.hbm.xml");
		}finally
		{
			if(session!=null)
			session.close();
		}
		
	
		return b;
	}
	public boolean updateBlog(Blog b)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(b);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:BlogDAO method:persistBlog ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public boolean persistBlog(Blog b)
	{
		Session session = null;
		Transaction trans = null;
		try
		{
			session = getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(b);
			trans.commit();
			return true;
		}catch(HibernateException e)
		{
			trans.rollback();
			System.out.println("Error: file:UserDAO method:persistBlog ");
			return false;
		}finally
		{
			if(session!=null)
				session.close();
		}
	}
	

}
