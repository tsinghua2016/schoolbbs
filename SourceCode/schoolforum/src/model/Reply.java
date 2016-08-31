package model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reply")
public class Reply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private Integer qid;
	private String replymsg;
	private Timestamp date;
	private String username;
	private Integer isread;
	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(Integer uid, Integer qid, String replymsg,Integer isread) {
		this.uid = uid;
		this.qid = qid;
		this.replymsg = replymsg;
		this.isread=isread;
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

	@Column(name = "qid", nullable = false)
	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	@Column(name = "replymsg", nullable = false)
	public String getReplymsg() {
		return this.replymsg;
	}

	public void setReplymsg(String replymsg) {
		this.replymsg = replymsg;
	}
	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "isread", nullable = false)
	public Integer getIsread() {
		return isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}

}