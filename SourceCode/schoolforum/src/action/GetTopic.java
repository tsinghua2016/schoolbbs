package action;

import java.util.List;

import model.NoticeDAO;
import model.Topic;
import model.TopicDAO;

import com.opensymphony.xwork2.ActionSupport;

public class GetTopic extends ActionSupport {
	private int page=0;
	private int count=10;
	private String searchmsg="";
	private TopicDAO topicdao;;
	private List<Topic> list;
	private String msg="";
	public String execute() throws Exception
	{
		
		list=topicdao.findNew(page, count);
		if(list.size()>0) page=list.get(list.size()-1).getId();
		else return "over";
		return "success";
	}
	public String search() throws Exception
	{
		msg=searchmsg;
		searchmsg=searchmsg.replace("%", "\\%");
		searchmsg=searchmsg.replace("_", "\\%");
		
		searchmsg=buidlike(searchmsg);
		list=topicdao.search(page,count,searchmsg);
		if(list.size()>0) {
			page=list.get(list.size()-1).getId();
			for(Topic temp:list)
			{
				temp.setTitle(temp.getTitle().replaceAll(msg, "<em>"+msg+"</em>"));
			}
		
		}
		else return "over";
		return "success";
	}

	private String buidlike(String msg) {
		// TODO Auto-generated method stub
		return  "%"+msg+"%";
	}
	public String getMsg() {
		return msg;
	}
	public void setSearchmsg(String searchmsg) {
		this.searchmsg = searchmsg;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public TopicDAO getTopicdao() {
		return topicdao;
	}
	public void setTopicdao(TopicDAO topicdao) {
		this.topicdao = topicdao;
	}
	public List<Topic> getList() {
		return list;
	}
	public void setList(List<Topic> list) {
		this.list = list;
	}
}
