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

import service.WardIdServ;

public class AjaxWardExistance extends HttpServlet {

	SessionFactory factory=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state;
		String city;
		String wardno;
		String msg = Constants.message("user login");
		PrintWriter pw = resp.getWriter();
		WardIdServ serv = new WardIdServ();
		if(req.getSession(false)!=null)
			if(req.getSession(false).getAttribute("user")!=null)
			{
				msg = Constants.error("parameters error");
				if(req.getParameter("state")!=null&&req.getParameter("city")!=null&&req.getParameter("wardno")!=null)
				{
					state = req.getParameter("state");
					city = req.getParameter("city");
					wardno = req.getParameter("wardno");
					msg = Constants.addTag("wardvalid", "Query");
					if(serv.validity(state, city, wardno, factory))
					{
						msg+=Constants.addTag("true", "value");
					}else
					{
						msg+=Constants.addTag("false", "value");
					}
					msg = Constants.message(msg);
					
				}
			}
		msg=Constants.addTag(msg, "wrapper");
		pw.write(msg);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
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
	
}
