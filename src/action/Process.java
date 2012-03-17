package action;

public class Process extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		if(req.getSession(false)!=null)
			if(req.getSession(false).getAttribute("user")!=null)
			{
				req.setAttribute("user", req.getSession(false).getAttribute("user"));
				return "loggedIn";
			}
		return "nLoggedIn";
	}
}
