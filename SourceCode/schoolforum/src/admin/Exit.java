package admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Exit extends ActionSupport {

	public String execute() throws Exception
	{
		ActionContext.getContext().getSession().put("superuser", null);
		return "fail";
		
	}
}
