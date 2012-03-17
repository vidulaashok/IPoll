package action;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.hibernate.Hibernate;
import org.springframework.util.FileCopyUtils;

import service.VoterIdServ;

import dao.FileContent;
import dao.FileInfo;
import dao.User;
import dao.VoterId;

public class VoterIdRegAction extends BaseAction {

	private File userPhoto = null;
    private String userPhotoContentType = null;
    private String userPhotoFilename = null;
    public VoterIdServ serv;
    
	/**
	 * @return the serv
	 */
	public VoterIdServ getServ() {
		return serv;
	}

	/**
	 * @param serv the serv to set
	 */
	public void setServ(VoterIdServ serv) {
		this.serv = serv;
	}

	/**
	 * @return the userPhoto
	 */
	public File getUserPhoto() {
		return userPhoto;
	}

	/**
	 * @param userPhoto the userPhoto to set
	 */
	public void setUserPhoto(File userPhoto) {
		this.userPhoto = userPhoto;
	}

	/**
	 * @return the userPhotoContentType
	 */
	public String getUserPhotoContentType() {
		return userPhotoContentType;
	}

	/**
	 * @param userPhotoContentType the userPhotoContentType to set
	 */
	public void setUserPhotoContentType(String userPhotoContentType) {
		this.userPhotoContentType = userPhotoContentType;
	}

	/**
	 * @return the userPhotoFilename
	 */
	public String getUserPhotoFileName() {
		return userPhotoFilename;
	}

	/**
	 * @param userPhotoFilename the userPhotoFilename to set
	 */
	public void setUserPhotoFileName(String userPhotoFilename) {
		this.userPhotoFilename = userPhotoFilename;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		String name=null;
		String surName;
		String currAdd;
		String currState;
		String currCity;
		String currWardNo;
		String pobAdd;
		String fathersName;
		String id;
		int day;
		int month;
		int year;
		Timestamp dob;
		String sex;
		String relId = null;
		if(req.getSession(false)!=null)
		{
			if(req.getSession(false).getAttribute("user")!=null)
				if(req.getSession(false).getAttribute("user").getClass()==User.class)
				{
					User user = (User)req.getSession(false).getAttribute("user");
					if(!serv.getVoterIdByUser(user.getId()))
					{
						if(req.getParameter("name")!=null&&req.getParameter("surName")!=null&&req.getParameter("day")!=null&&
								req.getParameter("month")!=null&&req.getParameter("year")!=null&&req.getParameter("pobL1")!=null
								&&req.getParameter("curL1")!=null&&req.getParameter("curCity")!=null
								&&req.getParameter("curState")!=null&&req.getParameter("curWardNo")!=null)
						{
							if(userPhoto!=null&&userPhotoContentType!=null&&userPhotoFilename!=null)
							{
								id=user.getId();
								name = req.getParameter("name");
								surName = req.getParameter("surName");
								
								currAdd = req.getParameter("curL1");
								if(req.getParameter("curL2")!=null)
									currAdd+=req.getParameter("curL2");
								
								pobAdd = req.getParameter("pobL1");
								if(req.getParameter("pobL2")!=null)
									pobAdd+=req.getParameter("pobL2");
								
								currCity = req.getParameter("curCity");
								currState = req.getParameter("curState");
								currWardNo = req.getParameter("curWardNo");
								sex = req.getParameter("Sex");
								relId = req.getParameter("relId");
								fathersName = req.getParameter("fName");
								
								
								day = Integer.parseInt(req.getParameter("day"));
								month = Integer.parseInt(req.getParameter("month"));
								year = Integer.parseInt(req.getParameter("year"));
								Calendar cal = Calendar.getInstance();
								cal.set(Calendar.YEAR, year);
								if (month == 12) {
									cal.set(Calendar.MONTH, Calendar.DECEMBER);
								} else if (month == 11) {
									cal.set(Calendar.MONTH, Calendar.NOVEMBER);
								} else if (month == 10) {
									cal.set(Calendar.MONTH, Calendar.OCTOBER);
								} else if (month == 9) {
									cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
								} else if (month == 8) {
									cal.set(Calendar.MONTH, Calendar.AUGUST);
								} else if (month == 7) {
									cal.set(Calendar.MONTH, Calendar.JULY);
								} else if (month == 6) {
									cal.set(Calendar.MONTH, Calendar.JUNE);
								} else if (month == 5) {
									cal.set(Calendar.MONTH, Calendar.MAY);
								} else if (month == 4) {
									cal.set(Calendar.MONTH, Calendar.APRIL);
								} else if (month == 3) {
									cal.set(Calendar.MONTH, Calendar.MARCH);
								} else if (month == 2) {
									cal.set(Calendar.MONTH, Calendar.FEBRUARY);
								} else if (month == 1) {
									cal.set(Calendar.MONTH, Calendar.JANUARY);
								}
								cal.set(Calendar.DATE, day);
								cal.set(Calendar.HOUR, 0);
								cal.set(Calendar.MINUTE, 0);
								cal.set(Calendar.SECOND,0);
								cal.set(Calendar.MILLISECOND, 0);
								dob = new Timestamp(cal.getTimeInMillis());
								
								Blob userImage;
								userImage = Hibernate.createBlob(FileCopyUtils.copyToByteArray(userPhoto));
								String userImageContentType = userPhotoContentType;
								String userImageFileName = userPhotoFilename;
								if(serv.writeVoterId(name, surName, currAdd, currState, currCity, currWardNo, dob, userImage, pobAdd, id, fathersName, sex,
										relId, userImageContentType,userImageFileName))
								{
									return "done";
								}
								else
								{
									if(serv.isWardID(currState, currCity, currWardNo))
										req.setAttribute("error", "Error :Already registered or Internal error, please try later.");
									else
										req.setAttribute("error", "Address seems to be invalid. please make sure you enter it right.(use the back button to refill the form.)");
									return "error";
								}
									
							}
							else
							{
								req.setAttribute("error", "ImageUploadFailed!!");
								return "error";
							}
						}
					}else{
						return "exist";
					}
					
				}else
				{
					req.setAttribute("error", "Empty fields!!");
					return "error";
				}
		}
		return "login";
	}

}
