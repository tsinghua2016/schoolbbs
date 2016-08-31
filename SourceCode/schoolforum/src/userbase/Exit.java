package userbase;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Constant;

public class Exit extends ActionSupport {

	public String execute() throws Exception
	{
		Cookie[] cookies =ServletActionContext.getRequest().getCookies();
		for(Cookie cookie:cookies)
		{
			cookie.setMaxAge(1);
			if(cookie.getName().equals("rember"))
				cookie.setValue("false");
			ServletActionContext.getResponse().addCookie(cookie);
		}
		ActionContext.getContext().getSession().put("user", null);
		ActionContext.getContext().getSession().put("uid", Constant.USERERRID);
		return NONE;
	}
}
