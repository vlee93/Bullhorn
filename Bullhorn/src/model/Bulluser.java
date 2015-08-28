package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="BULLUSER", schema="TESTDB")
@NamedQuery(name="Bulluser.findAll", query="SELECT b FROM Bulluser b")
public class Bulluser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	@Temporal(TemporalType.DATE)
	private Date joindate;

	private String motto;

	private String username;

	private String userpass;

	public Bulluser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

}