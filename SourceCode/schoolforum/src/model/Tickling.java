package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tickling entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tickling")
public class Tickling implements java.io.Serializable {

	// Fields

	private Integer id;
	private String msg;
	private Integer isread;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Tickling() {
	}

	/** full constructor */
	public Tickling(String msg, Integer isread, Timestamp date) {
		this.msg = msg;
		this.isread = isread;
		this.date = date;
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

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}