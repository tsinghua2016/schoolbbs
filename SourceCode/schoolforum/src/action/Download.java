package action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Download extends ActionSupport {
	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getDownloadFile() throws Exception  
	 {
		if(filename!=null && !("".equals(filename)))
		 return ServletActionContext.getServletContext().getResourceAsStream("upload/"+filename);
		else
			return null;
	 }
	public String execute() throws Exception
	{
		return SUCCESS;
	}

}
