package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;



@Entity
@Table(name="BULLHORN", schema="TESTDB")
@NamedQuery(name="Bullhorn.findAll", query="SELECT b FROM Bullhorn b")
public class Bullhorn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long postsid;

	@Temporal(TemporalType.DATE)
	private Date pdate;

	private String post;

	private long userid;

	public Bullhorn() {
	}

	public long getPostsid() {
		return this.postsid;
	}

	public void setPostsid(long postsid) {
		this.postsid = postsid;
	}

	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

}