package action;

import dao.User;
import service.VoterIdServ;

public class VoterRegReqAction extends BaseAction{
	VoterIdServ serv;
	
	public VoterIdServ getServ() {
		return serv;
	}

	public void setServ(VoterIdServ serv) {
		this.serv = serv;
	}

	@Override
	public String execute() throws Exception {
		User user = null;
	if(req.getSession(false)!=null)
		if(req.getSession(false).getAttribute("user")!=null)
		{
			req.setAttribute("user", user = (User) req.getSession(false).getAttribute("user"));
			if(serv.getVoterIdByUser(user.getId())&&serv!=null)
			{
				req.setAttribute("votercard", serv.getVoterIdObject());
				return "exist";
			}
			return "loggedIn";
		}
	return "nLoggedIn";
	}
	

}
