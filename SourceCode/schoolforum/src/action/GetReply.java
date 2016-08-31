package action;

import java.util.LinkedList;
import java.util.List;

import model.Reply;
import model.ReplyDAO;
import model.Topic;
import model.TopicDAO;
import model.User;
import model.UserDAO;

import com.opensymphony.xwork2.ActionSupport;

public class GetReply extends ActionSupport{

	private int id=-1;
	private int count=10;
	private int page=0;
	private ReplyDAO replydao;
	private TopicDAO topicdao;
	private UserDAO userdao;
	private Topic topic;
	private Reply reply=null;
	public List<Reply> getList() {
		return list;
	}

	public void setList(List<Reply> list) {
		this.list = list;
	}

	private List<Reply> list ;


	private String username;
	public String execute() throws Exception
	{
		topic=topicdao.findById(id);
		if(topic==null) return "fail";
		setUsername(userdao.findById(topic.getUid()).getUsername());
		list = replydao.findDetail(page,count,topic.getId());
		if(list.size()<=0) {page=0;return "over";}
		else
		{
			page=list.get(list.size()-1).getId();
		}
		
		return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReplyDAO getReplydao() {
		return replydao;
	}

	public void setReplydao(ReplyDAO replydao) {
		this.replydao = replydao;
	}

	public TopicDAO getTopicdao() {
		return topicdao;
	}

	public void setTopicdao(TopicDAO topicdao) {
		this.topicdao = topicdao;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
