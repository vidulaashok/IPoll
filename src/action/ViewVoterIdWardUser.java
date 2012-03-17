package action;

import service.RequestServ;
import service.UserServ;
import service.VoterIdServ;
import service.WardIdServ;
import dao.User;
import dao.VoterId;

public class ViewVoterIdWardUser extends BaseAction {

	VoterIdServ vserv;
	WardIdServ wserv;
	UserServ userv;
	RequestServ rserv;
	public RequestServ getRserv() {
		return rserv;
	}

	public void setRserv(RequestServ rserv) {
		this.rserv = rserv;
	}

	public VoterIdServ getVserv() {
		return vserv;
	}

	public void setVserv(VoterIdServ vserv) {
		this.vserv = vserv;
	}

	public WardIdServ getWserv() {
		return wserv;
	}

	public void setWserv(WardIdServ wserv) {
		this.wserv = wserv;
	}

	public UserServ getUserv() {
		return userv;
	}

	public void setUserv(UserServ userv) {
		this.userv = userv;
	}

	@Override
	public String execute() throws Exception {
		String voterid = null;
		String reqid = null;
		voterid = req.getParameter("voterid");
		reqid = req.getParameter("reqid");
		if(req.getSession(false)!=null&&voterid!=null&&reqid!=null)
		{
			if(req.getSession(false).getAttribute("user")!=null)
			{
				if(req.getSession(false).getAttribute("user") instanceof User)
				{
					User user = (User)req.getSession(false).getAttribute("user");
					if(user.getType().equalsIgnoreCase("warduser")||user.getType().equalsIgnoreCase("admin"))
					{
						if(user.getType().equalsIgnoreCase("warduser"))
						{
							if(vserv.getVoterId(voterid))
							{
								VoterId votercard = vserv.getVoterIdObject();
								if(votercard.getValidity()==0)
								{
									
								}else if(votercard.getValidity()==1)
								{
									
								}
							}
						}else
						{
							
						}
					}else
					{
						return "noauth";
					}
				}
			}
		}
		return "login";
	}
	
}
