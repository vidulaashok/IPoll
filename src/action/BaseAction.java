package action;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,ServletContextAware,ServletResponseAware {

	public HttpServletRequest req;
	public HttpServletResponse resp;
	public ServletContext context;
	
	
	
	public void setServletRequest(HttpServletRequest arg0) {
		req = arg0;
	}

	
	public void setServletContext(ServletContext arg0) {
		context = arg0;
	}

	
	public void setServletResponse(HttpServletResponse arg0) {
		resp = arg0;
	}

	
}
