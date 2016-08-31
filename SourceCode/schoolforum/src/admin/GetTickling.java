package admin;

import java.util.List;

import model.Tickling;
import model.TicklingDAO;
import model.Topic;

import com.opensymphony.xwork2.ActionSupport;

public class GetTickling extends ActionSupport {
	private int page=0;
	private List<Tickling> list;
	private TicklingDAO ticklingdao;

	public String execute() throws Exception
	{
		list=ticklingdao.findNew(page);
		if(list.size()>0) page=list.get(0).getId();
		else return "over";
		ticklingdao.update(page);
		return "success";
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public List<Tickling> getList() {
		return list;
	}
	public void setList(List<Tickling> list) {
		this.list = list;
	}
	public TicklingDAO getTicklingdao() {
		return ticklingdao;
	}
	public void setTicklingdao(TicklingDAO ticklingdao) {
		this.ticklingdao = ticklingdao;
	}
}
