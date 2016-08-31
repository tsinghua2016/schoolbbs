package action;

import java.sql.Timestamp;
import java.util.Calendar;

import model.Reply;
import model.ReplyDAO;
import model.Topic;
import model.TopicDAO;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Constant;

public class AddReply  {
	private String msg="";
	private TopicDAO topicdao;
	private String imagecode="";
	private String status;
	private ReplyDAO replydao;
	
	private int id;
	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception
	{
		status=Constant.OK_STR;
		int uid=Constant.USERERRID;
		if(ActionContext.getContext().getSession().get("uid")!=null)
			uid=(Integer) ActionContext.getContext().getSession().get("uid");
		
		if("".equals(msg.trim()) 
				|| uid==Constant.USERERRID)
			{
				status="内容不能为空";
			}
		else{
			String code=(String)(ActionContext.getContext().getSession().get("imagecode"));
			if(code==null || imagecode==null || !(imagecode.equalsIgnoreCase(code)))
			{
				
				setStatus("验证码错误");
			}
			else if(topicdao.findById(id)==null) setStatus("问题不存在");
			else 
			{
				msg=Constant.dochange(msg);
				Topic author=topicdao.findById(id);
				Reply reply =new Reply();
				reply.setQid(id);
				reply.setUid(uid);
				reply.setReplymsg(msg);
				if(author.getUid()==uid)
				reply.setIsread(1);
				else reply.setIsread(0);
				reply.setUsername((String)ActionContext.getContext().getSession().get("user"));
				Timestamp date =new Timestamp(System.currentTimeMillis());
				reply.setDate(date);
				replydao.save(reply);
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

	public void setTopicdao(TopicDAO topicdao) {
		this.topicdao = topicdao;
	}


	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setReplydao(ReplyDAO replydao) {
		this.replydao = replydao;
	}
}
