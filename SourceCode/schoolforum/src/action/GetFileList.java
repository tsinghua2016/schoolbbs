package action;
import java.io.File;  
import java.io.IOException;  
import java.util.List;  

import model.Uploadfiles;
import model.UploadfilesDAO;
import model.User;
import model.UserDAO;

import org.apache.commons.io.FileUtils;  
import org.apache.struts2.ServletActionContext;  

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
public class GetFileList extends ActionSupport {  
  
    // 上传多个文件的集合文本  
    protected UploadfilesDAO uploadfilesDAO; 
    List<Uploadfiles> filelist;
    public List<Uploadfiles> getFilelist() {
		return filelist;
	}
	public String execute() {  
  
       // 把上传的文件放到指定的路径下  
       filelist=uploadfilesDAO.findAll();

       
       return SUCCESS;  
    }


	public void setUploadfilesDAO(UploadfilesDAO uploadfilesDAO) {
		this.uploadfilesDAO = uploadfilesDAO;
	}  
}  