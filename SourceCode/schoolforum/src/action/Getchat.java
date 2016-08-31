package action;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Getchat extends ActionSupport{
	private ReplyDAO replydao;
	private ChatDAO chatdao;
	private int page;
	private UserDAO userdao;
	private List<ListMsg> array;
	public String execute() throws Exception
	{
		Object obj= ActionContext.getContext().getSession().get("uid");
		if (obj==null||((Integer)(obj)<0)) 
			return "fail";
		int uid=(Integer) obj;
		List<Reply> listreply=replydao.findAllMsg(uid);
		if (listreply!=null&&listreply.size()>0)
		{
		
			if (array==null) {
				array=new ArrayList<ListMsg>();
				ListMsg.clear();
			}
			for(Reply temp:listreply)
			{
				array.add(new ListMsg(userdao.findById(temp.getUid()).getUsername(), 
						temp.getDate(),temp.getReplymsg(),temp.getUid(),temp.getId(),temp.getIsread()));
			}
		}
		List<Chat> listchat=chatdao.findAllmsg(uid);
		if(listchat!=null&&listchat.size()>0)
		{
			if (array==null) {
				array=new ArrayList<ListMsg>();
				ListMsg.clear();
			}
			for(Chat temp:listchat)
				array.add(new ListMsg(userdao.findById(temp.getUid()).getUsername(), 
						temp.getChattime(),temp.getMsg(),temp.getUid(),temp.getQid(),temp.getIsread()));
		}
		if (array!=null &&array.size()>0){ 
			  Collections.sort(array, new ComparatorTime());
			  page=1;
			}
		else page=0;
		replydao.setRead(uid);
		chatdao.setRead(uid);
		ActionContext.getContext().getSession().put("msgnum",0);
		return "success";

	}
	public List<ListMsg> getArray() {
		return array;
	}
	public void setReplydao(ReplyDAO replydao) {
		this.replydao = replydao;
	}
	public void setChatdao(ChatDAO chatdao) {
		this.chatdao = chatdao;
	}
	public int getPage() {
		return page;
	}
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
}

