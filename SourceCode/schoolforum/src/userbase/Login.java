package userbase;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import model.Chat;
import model.ChatDAO;
import model.ReplyDAO;
import model.TopicDAO;
import model.User;
import model.UserDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Constant;

public class Login  {

	private String email;
	private String password;
	private UserDAO userdao;
	private String imagecode;
	private boolean rember;
	private String status;
	private ChatDAO chatdao;
	private ReplyDAO replydao;

	public String execute() throws Exception
	{
		String code=(String)(ActionContext.getContext().getSession().get("imagecode"));
		if(code==null || imagecode==null || !(imagecode.equalsIgnoreCase(code)))
			setStatus("验证码错误");
		else if(email!=null &&password!=null)
		{
			List<User> list=userdao.findByEmail(email);
			if(list.size()>0 )
			{
				if(list.get(0).getPassword().equals(password))
				{
					Integer uid=list.get(0).getId();
					setStatus("ok");
					ActionContext.getContext().getSession().put("user", list.get(0).getUsername());
					ActionContext.getContext().getSession().put("uid", list.get(0).getId());
					int msgnum=chatdao.findNotRead(uid).size()+replydao.findNotRead(uid);
					ActionContext.getContext().getSession().put("msgnum", msgnum);
					if(rember)
					{
						Cookie remcookie = new Cookie("rember" , "true");
						remcookie.setMaxAge(24 * 3600 * 30);
						Cookie emailcookie=new Cookie("email",email);
						emailcookie.setMaxAge(24 * 3600 * 30);
						Cookie passcookie=new Cookie("password",password);
						passcookie.setMaxAge(24 * 3600 * 30);
						ServletActionContext.getResponse().addCookie(passcookie);
						ServletActionContext.getResponse().addCookie(emailcookie);
						ServletActionContext.getResponse().addCookie(remcookie);
					}
					
				}
				else 
					setStatus("密码错误");;
			}
			else setStatus("用户不存在");
			
		}
		return "success";
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


	public void setRember(boolean rember) {
		this.rember = rember;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setChatdao(ChatDAO chatdao) {
		this.chatdao = chatdao;
	}
	public void setReplydao(ReplyDAO replydao) {
		this.replydao = replydao;
	}

}
