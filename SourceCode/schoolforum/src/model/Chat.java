package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "chat", catalog = "schoolbbs")
public class Chat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private Integer qid;
	private Integer touid;
	private String msg;
	private Integer isread;
	private Timestamp chattime;
	// Constructors

	/** default constructor */
	public Chat() {
	}
	/** full constructor */
	public Chat(Integer uid, Integer qid, Integer touid, String msg,
			Integer isread) {
		this.uid = uid;
		this.qid = qid;
		this.touid = touid;
		this.msg = msg;
		this.isread = isread;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "rid", nullable = false)
	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	@Column(name = "touid", nullable = false)
	public Integer getTouid() {
		return this.touid;
	}

	public void setTouid(Integer touid) {
		this.touid = touid;
	}

	@Column(name = "msg", nullable = false, length = 65535)
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "isread", nullable = false)
	public Integer getIsread() {
		return this.isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	@Column(name = "chattime", nullable = false)
	public Timestamp getChattime() {
		return chattime;
	}
	public void setChattime(Timestamp chattime) {
		this.chattime = chattime;
	}

}