package action;

import java.sql.Timestamp;
import java.util.Date;

import dao.User;
import service.UserServ;

public class RegisterAction extends BaseAction {
private UserServ  serv;

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
	String user=null;
	String password=null;
	String conPassword=null;
	String email=null;
	String language=null;
	user = req.getParameter("user");
	password = req.getParameter("password");
	conPassword = req.getParameter("conPassword");
	email = req.getParameter("email");
	language = req.getParameter("language");
	req.setAttribute("msg", "Error: the values entered <br> in the form are <b>incorrect</b>.");
	if((user!=null&&password!=null&&conPassword!=null&&email!=null&language!=null)&&password.equals(conPassword))
	{
		User us = new User(user,password,"Normal",language,new Timestamp(new Date().getTime()),new Timestamp(new Date().getTime()),email);
		us.setValidity(1);
		if(serv.writeUser(us))
			return "done";
		req.setAttribute("msg", "Error: the values entered <br> in the form are <b>incorrect</b>.<br>Database error.");
		return "inputError";
	}
	return "inputError";
}

}
