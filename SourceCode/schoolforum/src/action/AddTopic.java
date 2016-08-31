package action;

import java.sql.Timestamp;
import java.util.Calendar;

import model.Topic;
import model.TopicDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Constant;

public class AddTopic  {
	private String title="";
	private String detail="";
	private TopicDAO topicdao;
	private String imagecode="";
	private String status;
	public String execute() throws Exception
	{
		status=Constant.OK_STR;
		int uid=Constant.USERERRID;
		if(ActionContext.getContext().getSession().get("uid")!=null)
			uid=(Integer) ActionContext.getContext().getSession().get("uid");
		
		if("".equals(title.trim()) || "".equals(detail.trim()) 
				|| uid==Constant.USERERRID)
		{
			status="标题或者内容不能为空";
		}
		else{
			String code=(String)(ActionContext.getContext().getSession().get("imagecode"));
			if(code==null || imagecode==null || !(imagecode.equalsIgnoreCase(code)))
			{
				
				setStatus("验证码错误");
			}
			else
			{
				detail=Constant.dochange(detail);
				title=Constant.dochange(title);
				Topic topic =new Topic();
				topic.setDetail(detail);
				topic.setTitle(title);
				topic.setUid(uid);
				topic.setReply(new Long(0));
				Timestamp date =new Timestamp(System.currentTimeMillis());
				topic.setDate(date);
				topicdao.save(topic);
				
			}	
		}
		return "success";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setTopicdao(TopicDAO topicdao) {
		this.topicdao = topicdao;
	}


	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}
}
