package action;

import dao.User;
import service.VoterIdServ;

public class veiwVerifyVoterIdAction extends BaseAction {

	VoterIdServ serv;
	
	public VoterIdServ getServ() {
		return serv;
	}

	public void setServ(VoterIdServ serv) {
		this.serv = serv;
	}

	@Override
	public String execute() throws Exception {
		String reqid;
		String voterid;
		User user = null;
		if(req.getSession(false)!=null)
		{
			long id;
			reqid = req.getParameter("reqid");
			voterid = req.getParameter("voterid");
			
			if(voterid!=null&&reqid!=null)
			{
				id = Long.parseLong(reqid);
				if(serv.isRequestForVoterId(id))
				{
					user = (User)req.getSession(false).getAttribute("user");
					if(user!=null)
					{
						req.setAttribute("user", user);
						if(user.getType().compareToIgnoreCase("warduser")==0||user.getType().compareToIgnoreCase("admin")==0)
						{
							if(serv.getVoterId(voterid))
							{
								if(serv.getReq4voterid().getVoterid().compareToIgnoreCase(voterid)==0)
								{	
									req.setAttribute("votercard",serv.getVoterIdObject());
									return "view";
								}else
								{
									req.setAttribute("error", "Invalid request. Do you know what you are doing ?");
									return "error";
								}
							}else
							{
								req.setAttribute("error", "Invalid request. Do you know what you are doing ?");
								return "error";
							}
						}else
						{
							req.setAttribute("error", "You dont have permission to view this page.");
							return "error";
						}
					}else
					{
						return "nLoggedIn";
					}
				}else
				{
					req.setAttribute("error", "The voterid is no longer under request.");
					return "error";
				}
			}
		}
		return "nLoggedIn";
	}

}
