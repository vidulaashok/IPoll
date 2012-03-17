package action;

import dao.User;
import service.CandidateServ;

public class CandidateRegReqAction extends BaseAction {

	/*public CandidateRegReqAction(){
	
	}*/
	private CandidateServ serv;
	
	
	public CandidateServ getServ() {
		return serv;
	}


	public void setServ(CandidateServ serv) {
		this.serv = serv;
	}


	@Override
	public String execute()throws Exception {
		User user;
		
		if(req.getSession(false)!=null)
		{
			if(req.getSession(false).getAttribute("user")!=null)
			{
				req.setAttribute("user", user= (User) req.getSession(false).getAttribute("user"));
				if(serv.getCandidateIdByUser(user.getId())&&serv!=null )
				{
					req.setAttribute("candidatecard", serv.getCandidate());
					return "exist";
				}
				return "loggedIn";
			}
		}
		return "nLoggedIn";
	}
	
}
