package action;

import javax.servlet.http.HttpSession;

import org.apache.commons.chain.web.servlet.ServletSetLocaleCommand;

import service.UserServ;

public class LoginAction extends BaseAction {
	private UserServ serv;

	/**
	 * @return the serv
	 */
	public UserServ getServ() {
		return serv;
	}

	/**
	 * @param serv the serv to set
	 */
	public void setServ(UserServ serv) {
		this.serv = serv;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		HttpSession session;
		String name;
		String password;
		if(req.getParameter("user")!=null&&req.getParameter("pswd")!=null)
		{
			session = req.getSession();	
			name=req.getParameter("user");
			password = req.getParameter("pswd");
			if(	serv.isValidUser(name, password))
			{
				session.setAttribute("user", serv.getUser());
				req.setAttribute("user", serv.getUser());
				return "Home";
			}
			else
			{
				req.setAttribute("error", "Please enter a valid combination.");
				return "error";
			}
		}
		req.setAttribute("error", "Please enter a valid combination.");
		return "error";
	}
	
}
