package model;

import java.sql.Timestamp;

public class ListMsg
{
	private String username;
	private Timestamp time;
	private String msg;
	private Integer uid;
	private static int id=0;
	private int mid;
	private Integer qid;
	private int isread;
	public static void  clear()
	{
		id=0;
	}
	public ListMsg(String username, Timestamp time, String msg,Integer uid,Integer qid,int isread) {
		this.username = username;
		this.time = time;
		this.msg = msg;
		this.uid=uid;
		this.mid=id;
		this.setQid(qid);
		this.setIsread(isread);
		id++;
	}
	public int getMid()
	{
		return mid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsename(String username) {
		this.username = username;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getIsread() {
		return isread;
	}
	public void setIsread(int isread) {
		this.isread = isread;
	}
}