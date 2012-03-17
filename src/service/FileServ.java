package service;

import org.hibernate.SessionFactory;

import dao.FileContent;
import dao.FileDAO;
import dao.FileInfo;

public class FileServ {
	FileDAO fDao;
	
	public FileContent getFileContent(String fileId,SessionFactory s)
	{
		if(fDao==null)
			fDao = new FileDAO();
		if(fDao.getSessionFactory()==null)
			fDao.setSessionFactory(s);
		return fDao.getFileContent(fileId);
	}
	
	public FileInfo getFileInfo(String fileId,SessionFactory s)
	{
		if(fDao==null)
			fDao = new FileDAO();
		if(fDao.getSessionFactory()==null)
			fDao.setSessionFactory(s);
		return fDao.getFileInfo(fileId);
	}
}
