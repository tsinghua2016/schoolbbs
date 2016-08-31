package admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	private static final String NAME="test";
	private static final String PASSWD="test";
	private String user;
	private String pass;
	public String execute()throws Exception
	{
		if(NAME.equals(user)&&PASSWD.equals(pass)){
			ActionContext.getContext().getSession().put("superuser", user);
			return "success";
		}
		return "fail";
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
