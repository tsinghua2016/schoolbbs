package model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Uploadfiles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uploadfiles", catalog = "schoolbbs", uniqueConstraints = @UniqueConstraint(columnNames = "filename"))
public class Uploadfiles implements java.io.Serializable {

	// Fields

	private Integer int_;
	private User user;
	private String filename;
	private Timestamp uploadtime;

	// Constructors

	/** default constructor */
	public Uploadfiles() {
	}

	/** full constructor */
	public Uploadfiles(User user, String filename, Timestamp uploadtime) {
		this.user = user;
		this.filename = filename;
		this.uploadtime = uploadtime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "int", unique = true, nullable = false)
	public Integer getInt_() {
		return this.int_;
	}

	public void setInt_(Integer int_) {
		this.int_ = int_;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "filename", unique = true)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "uploadtime", length = 19)
	public Timestamp getUploadtime() {
		return this.uploadtime;
	}

	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}
	

}