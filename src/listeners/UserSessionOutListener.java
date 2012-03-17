package listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.User;

import service.UserServ;


public class UserSessionOutListener implements HttpSessionAttributeListener {
	SessionFactory factory=null;
	UserServ serv=new UserServ();
	
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void attributeRemoved(HttpSessionBindingEvent arg) {
		
		if(arg.getValue() instanceof User)
		{
			factory = new Configuration().configure().buildSessionFactory();
			
			if(factory!=null)
			{
			serv.logOffUser((User)arg.getValue(), factory);
			}
		}
	}
	
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
