package admin;

import java.sql.Timestamp;

import org.apache.struts2.ServletActionContext;

import model.Notice;
import model.NoticeDAO;

import com.opensymphony.xwork2.ActionSupport;

import constant.Constant;

public class AddNotice extends ActionSupport{
	private String title="";
	private String detail="";
	private NoticeDAO noticedao;
	
	public String execute() throws Exception
	{
		if(title!=null&&detail!=null&&
				(!"".equals(detail.trim()))&&(!"".equals(title.trim())))
		{
			title=Constant.dochange(title);
			detail=Constant.dochange(detail);
			Notice notice=new Notice(title, detail, new Timestamp(System.currentTimeMillis()));
			noticedao.save(notice);
			
		}
		
		return NONE;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public NoticeDAO getNoticedao() {
		return noticedao;
	}

	public void setNoticedao(NoticeDAO noticedao) {
		this.noticedao = noticedao;
	}

}	
