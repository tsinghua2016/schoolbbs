package action;

import java.util.List;

import model.NoticeDAO;
import model.Notice;

import com.opensymphony.xwork2.ActionSupport;

public class GetNotice extends ActionSupport {

	private int page=0;
	private int count=10;
	private NoticeDAO noticedao;
	private List<Notice> list;
	public String execute() throws Exception
	{
		
		list=noticedao.findNew(page, count);
		if(list.size()>0) page=list.get(list.size()-1).getId();
		else return "over";
		return "success";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public NoticeDAO getNoticedao() {
		return noticedao;
	}
	public void setNoticedao(NoticeDAO noticedao) {
		this.noticedao = noticedao;
	}
	public List<Notice> getList() {
		return list;
	}
	public void setList(List<Notice> list) {
		this.list = list;
	}
}
