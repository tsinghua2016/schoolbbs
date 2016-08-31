package action;

import java.sql.Timestamp;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import model.Tickling;
import model.TicklingDAO;



import constant.Constant;

public class AddTickling  {
	private String msg="";
	private String imagecode="";
	private TicklingDAO ticklingdao;
	private String status;
	public String execute() throws Exception
	{
		status=Constant.OK_STR;
		if("".equals(msg.trim()) || "".equals(msg.trim()))
		{
			status="内容不能为空";
		}
		else 
		{
			
			String code=(String)(ActionContext.getContext().getSession().get("imagecode"));
			if(code==null || imagecode==null || !(imagecode.equalsIgnoreCase(code)))
			{
				
				setStatus("验证码错误");
			}
			else
			{
				
				Tickling tickling=new Tickling();
				tickling.setMsg(Constant.dochange(msg));
				Timestamp date =new Timestamp(System.currentTimeMillis());
				tickling.setDate(date);
				tickling.setIsread(0);
				ticklingdao.save(tickling);
				
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

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setTicklingdao(TicklingDAO ticklingdao) {
		this.ticklingdao = ticklingdao;
	}

	public void setImagecode(String imagecode) {
		this.imagecode = imagecode;
	}


}
