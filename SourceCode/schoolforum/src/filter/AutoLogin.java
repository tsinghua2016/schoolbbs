package filter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;















import model.ChatDAO;
import model.ReplyDAO;
import model.TopicDAO;
import model.User;
import model.UserDAO;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;

import constant.Constant;

public class AutoLogin implements Filter{

	private FilterConfig conf;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		conf=null;
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("uid")==null)	{
			ActionContext.getContext().getSession().put("uid", Constant.USERERRID);
			autoJudge();
		}
		chain.doFilter(requ, resp);
	}
	private void autoJudge()
	{
		Cookie[] cookies=ServletActionContext.getRequest().getCookies();
		if(cookies==null)return;
		String email=null;
		String password=null;
		boolean flag=false;
		
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals("rember"))
			{
				if(cookie.getValue().equals("true"))
					flag=true;
				else break;
			
			}
			else if(cookie.getName().equals("email"))
			{
				email=cookie.getValue();
			}
			else if(cookie.getName().equals("password"))
			{
				password=cookie.getValue();
			}
		}
		if(flag)
		{
			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext()); 
			UserDAO userdao;userdao=(UserDAO) webApplicationContext.getBean("userdao");
			
			User user=new User();
			user.setEmail(email);
			user.setPassword(password);
			List<User> list=userdao.findByExample(user);
			if(list.size()>0){
				ActionContext.getContext().getSession().put("user", list.get(0).getUsername());
				ActionContext.getContext().getSession().put("uid", list.get(0).getId());
				ReplyDAO replydao=(ReplyDAO) webApplicationContext.getBean("replydao");
				ChatDAO chatdao=(ChatDAO) webApplicationContext.getBean("chatdao");
				int msgnum=replydao.findNotRead(user.getId())+chatdao.findNotRead(user.getId()).size();
				ActionContext.getContext().getSession().put("msgnum", msgnum);
			}
				
		}
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.conf=arg0;
	}


}
