package userbase;



import model.User;
import model.UserDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import constant.Constant;


public class Register {

	private String username;
	private String password;
	private String email;
	private String imagecode;
	private UserDAO userdao;
	private String status;
	public String execute() throws Exception
	{
		if(username!=null &&password!=null&&email!=null&&imagecode!=null)
		{
			String rightcode=(String)ActionContext.getContext().getSession().get("imagecode");
			if(rightcode==null || !rightcode.equalsIgnoreCase(imagecode))
			{
				setStatus("验证码错误");
			}
			else
			{
				if(userdao.findByEmail(email).size()>0) setStatus("邮箱已被注册");
				else if(userdao.findByUsername(username).size()>0) setStatus("用户名已经被使用");
				else
				{
					User user=new User();
					user.setEmail(email);
					user.setPassword(password);
					user.setUsername(username);
					userdao.save(user);
					setStatus(Constant.OK_STR);
					ActionContext.getContext().getSession().put("user", username);
					ActionContext.getContext().getSession().put("uid", user.getId());
				}
			}
			
		}
		return "success";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
