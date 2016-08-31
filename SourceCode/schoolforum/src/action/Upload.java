package action;
import java.io.File;  
import java.io.IOException;  
import java.sql.Timestamp;
import java.util.List;  

import model.Uploadfiles;
import model.UploadfilesDAO;
import model.User;
import model.UserDAO;

import org.apache.commons.io.FileUtils;  
import org.apache.struts2.ServletActionContext;  

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
public class Upload extends ActionSupport {  
    private static final long serialVersionUID = 1L;  
    private String name;  
  
    // 上传多个文件的集合文本  
    private UploadfilesDAO uploadfilesDAO; 
    private File upload;  
    private UserDAO userdao;
    public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}


	private String uploadFileName;  
  
    public void setName(String name) {  
  
       this.name = name;  
    }  
  
  
    public void setUpload(File upload) {  
  
       this.upload = upload;  
    }  
  

  
    public void setUploadFileName(String uploadFileName) {  
  
       this.uploadFileName = uploadFileName;  
    }  
  
    public String execute() {  
  
       // 把上传的文件放到指定的路径下  
       String path =ServletActionContext.getServletContext().getRealPath("/upload");  

       File file = new File(path);  
  
       if (!file.exists()) {  
           file.mkdirs();  
           
       }  
       int uid=(Integer) ActionContext.getContext().getSession().get("uid");
       File savefile= new File(file, uploadFileName);
       System.out.println("upload "+savefile.exists() +" "+ (uid==0));
       if(savefile.exists() || uid==0) return "fail";
           try {  
              FileUtils.copyFile(upload,savefile); 
              User user=userdao.findById(uid);
              Uploadfiles newfile=new Uploadfiles(user, uploadFileName,new Timestamp(System.currentTimeMillis()));
              uploadfilesDAO.save(newfile);
 
           } catch (IOException e) {  

              e.printStackTrace();  
           }  
           
        
       return SUCCESS;
    }


	public void setUploadfilesDAO(UploadfilesDAO uploadfilesDAO) {
		this.uploadfilesDAO = uploadfilesDAO;
	}





}  