package constant;

import com.opensymphony.xwork2.ActionContext;

public final class Constant {

	public static int ERROR=1;
	public static int OK=0;
	public static int USERERRID=-1;
	public static String OK_STR="ok";
	public static int ERROR_IMAGE_CODE=3;
	public static int timedelta=-3;
	public static  String dochange(String msg)
	{
		msg=msg.trim()
			.replaceAll(">","&gt;")
			.replaceAll("<", "&lt;")
			.replaceAll("\n","<br/>");
		return msg;
	}
	public static void clearcode()
	{
		ActionContext.getContext().put("imagecode", Math.random()*1000+"");
	}
}
