package action;

import service.UserServ;


public class LogoutAction extends BaseAction {
	UserServ serv;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if(req.getSession(false)!=null)
			if(req.getSession(false).getAttribute("user")!=null)
			{
				req.getSession(false).removeAttribute("user");
				req.getSession(false).invalidate();
				return "login";
			}
		return "login";
	}
	
}
