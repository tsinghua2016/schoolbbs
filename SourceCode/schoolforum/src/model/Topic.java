package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "topic")
public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private String title;
	private String detail;
	private Long reply;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(Integer uid, String title, String detail, Long reply,
			Timestamp date,Integer isread) {
		this.uid = uid;
		this.title = title;
		this.detail = detail;
		this.reply = reply;
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

	@Column(name = "uid", nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "title", nullable = false, length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "detail", nullable = false)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "reply", nullable = false)
	public Long getReply() {
		return this.reply;
	}

	public void setReply(Long reply) {
		this.reply = reply;
	}

	@Column(name = "date", nullable = false, length = 0)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}