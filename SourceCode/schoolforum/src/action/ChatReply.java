package action;


import java.sql.Timestamp;

import model.*;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Constant;

public class ChatReply  extends ActionSupport{
	
	private int uid=-1;
	private String data=null;
	private ChatDAO chatdao;
	private int qid=-1;

	public String execute() throws Exception
	{

		if(uid!=-1 && data!=null &&qid!=-1)
		{
			Chat chat=new Chat();
			Timestamp date =new Timestamp(System.currentTimeMillis());
			chat.setTouid(uid);
			chat.setMsg(data);
			chat.setChattime(date);
			int author=(Integer)(ActionContext.getContext().getSession().get("uid"));
			if(uid==author)chat.setIsread(1);
			else chat.setIsread(0);
			chat.setUid(author);
			chat.setQid(qid);
			chatdao.save(chat);
			
		}	
		
		return NONE;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public void setChatdao(ChatDAO chatdao) {
		this.chatdao = chatdao;
	}
}