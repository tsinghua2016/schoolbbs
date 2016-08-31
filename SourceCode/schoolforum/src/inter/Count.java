package inter;

import java.util.Date;
import java.util.Map;

import model.ChatDAO;
import model.ReplyDAO;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


	public class Count extends AbstractInterceptor {  
		  
	    @Override  
	    public String intercept(ActionInvocation invocation) throws Exception {  
	  
	        // 取得请求相关的ActionContext实例  
	        Object obj=ActionContext.getContext().getSession().get("uid");
	        if (obj!=null)
	        {
	        	int uid=(Integer)obj;
	        	if(uid>0) 
	        	{
	    			WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext()); 
	    			ReplyDAO replydao=(ReplyDAO) webApplicationContext.getBean("replydao");
	    			ChatDAO chatdao=(ChatDAO) webApplicationContext.getBean("chatdao");
	    			uid=(Integer) ActionContext.getContext().getSession().get("uid");
	    			int msgnum=replydao.findNotRead(uid)+chatdao.findNotRead(uid).size();
	    			ActionContext.getContext().getSession().put("msgnum", msgnum);
	        	}
	        	
	        }
	        return invocation.invoke();
	    }  
	  

}
