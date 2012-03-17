package action;

import java.util.HashMap;

import service.RequestServ;
import dao.Request;
import dao.RequestForVoterId;
import dao.User;

public class RequestForVoterIdWardUserAction extends BaseAction {

	RequestServ serv;
	@Override
	public String execute() throws Exception {
		User user = null;
		if(req.getSession(false)!=null)
			if(( req.getSession(false).getAttribute("user")) != null)
			{
				if(req.getSession(false).getAttribute("user") instanceof User)
				{
					user = (User)req.getSession(false).getAttribute("user");
					req.setAttribute("user", user);
					if(user.getType().equalsIgnoreCase("WardUser"))
					{
						HashMap<Request,RequestForVoterId> hm = serv.getRequestForVoterIdWardUser(user.getId());
						req.setAttribute("reqforvoterid", hm);
						
						return "view";
					}
					req.setAttribute("error", "Dear "+user.getId()+",\n\tYou donot have the <b>permission</b>.\n\tPlease contact the admin for further details.");
					return "noAuthority";
				}
			}
		return "nLoggedIn";
	}
	public RequestServ getServ() {
		return serv;
	}
	public void setServ(RequestServ serv) {
		this.serv = serv;
	}
	
}
