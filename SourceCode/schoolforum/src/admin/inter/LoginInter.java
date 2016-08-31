package admin.inter;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInter extends AbstractInterceptor {  
 
    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  
  
        // 取得请求相关的ActionContext实例  
        ActionContext ctx = invocation.getInvocationContext();  
        Map session = ctx.getSession();  
        String user = (String) session.get("superuser");  
  
        // 如果没有登陆，即用户名不存在，都返回重新登陆  
        if (user != null) {  
            return invocation.invoke();  
        }  

        return "fail";    //返回一个叫login的result结果
  
    }  
}