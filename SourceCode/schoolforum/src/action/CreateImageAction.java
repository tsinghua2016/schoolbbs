package action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext; 

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateImageAction extends ActionSupport
{
    @Override
    public String execute() throws Exception
    {
    	int width=200;
    	int height=100;
    	char[] msg={
    			'2','3','4','5','6','7','8','9',
    			'q','w','e','r','t','y','u','i',
    			'p','a','s','d','f','g','h','j','k','z',
    			'x','c','v','b','n','m'};
    		int len =msg.length;
    		StringBuffer string=new StringBuffer();
    		for(int j=0;j<4;j++)
    		{
    			int i=(int)(Math.random()*len);
    			string.append(msg[i]);
    			
    		}
    		ActionContext.getContext().getSession().put("imagecode", string.toString() );
    		
    		BufferedImage image=new BufferedImage(85, 40,BufferedImage.TYPE_INT_RGB);
    		Graphics g=image.getGraphics();
    		g.fillRect(0, 0, width, height);
    		g.setColor(Color.RED);
    		g.setFont(new Font("Arial Black",Font.PLAIN,25));
    		g.drawString(string.toString(), 10,25);
    		for(int i=0;i<12;i++)
    		{
    			g.drawLine((int)(Math.random()*width/2), (int)(Math.random()*height/2), (int)(Math.random()*width/2), (int)(Math.random()*height/2));
    			g.drawLine((int)(Math.random()*width), (int)(Math.random()*height), (int)(Math.random()*width), (int)(Math.random()*height));
    		}
    		g.dispose();
    		ImageIO.write(image, "png", ServletActionContext.getResponse()
    				.getOutputStream());
    		return null;
    }

}