package action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import service.FileServ;

import dao.FileContent;
import dao.FileInfo;

public class FileAction extends HttpServlet {
	
	SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String file = req.getParameter("fileid");
		FileServ serv;
		FileInfo fil;
		FileContent content;
		ServletOutputStream out = resp.getOutputStream();
		if(file!=null)
		{
			if(sessionFactory!=null)
			{
				serv = new FileServ();
				fil = serv.getFileInfo(file, sessionFactory);
				content = serv.getFileContent(file, sessionFactory);
				resp.setContentType(fil.getDisc());
				try
				{
				resp.setContentLength((int) content.getBlob().length());
				Blob f = content.getBlob();
				InputStream in = f.getBinaryStream();
			      int length = (int) f.length();
			      int bufferSize = 1024;
			      byte[] buffer = new byte[bufferSize];
			      while ((length = in.read(buffer)) != -1) {
			        out.write(buffer, 0, length);
			      }
			      in.close();
			      out.flush();
				}catch(SQLException s)
				{
					System.err.println("Error: sql exception.");
					s.printStackTrace();
				}
				catch(IOException e)
				{
					System.err.println("Error: I/O exception.");
					e.printStackTrace();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(HibernateException h)
		{
			System.err.println("Error: at FileAction method: Init().");
			h.printStackTrace();
		}
	}
	
}
