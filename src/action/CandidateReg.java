package action;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.util.FileCopyUtils;

import service.CandidateServ;

import dao.FileContent;
import dao.FileInfo;
import dao.User;

public class CandidateReg extends BaseAction{

	@Override
	public String execute() throws Exception {
		if(req.getSession(false)!=null)
		{
			if(req.getSession(false).getAttribute("user")!=null)
			{
			
				return "success";
			}
			
		}
		return "nLoggedIn";
	}	
}
