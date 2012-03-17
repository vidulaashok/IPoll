package action;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import service.UserServ;

public class AjaxUserExistance extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	SessionFactory factory=null;
	@Override
	public void init() throws ServletException {
		try
		{
		factory = new Configuration().configure().buildSessionFactory();
		}catch(HibernateException h)
		{
			h.printStackTrace();
			System.out.println("Servlet Hibernate config error.");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = null;
		UserServ serv = null;
		serv = new UserServ();
		name = req.getParameter("user");
		PrintWriter pw = resp.getWriter();
		if(name!=null&&serv!=null)
		{
			if(serv.isUser(name,factory))
			{
				String msg = Constants.addTag("UserExist", "Query");
				String msgVal = Constants.addTag("true", "value");
				msg += msgVal;
				msg = Constants.message(msg);
				msg = Constants.addTag(msg, "wrapper");
				pw.write(msg);
				return;
			}
			String msg = Constants.addTag("UserExist", "Query");
			String msgVal = Constants.addTag("false", "value");
			msg += msgVal;
			msg = Constants.message(msg);
			msg = Constants.addTag(msg, "wrapper");
			pw.write(msg);
			return;
		}
		String msg = Constants.addTag("UserExist","Query");
		msg += Constants.addTag("error", "value");
		msg = Constants.message(msg);
		msg = Constants.addTag(msg, "wrapper");
		pw.write(msg);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
