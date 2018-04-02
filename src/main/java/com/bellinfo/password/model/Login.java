package com.bellinfo.password.model;

public class Login {

	String userid;
	String password;

	public Login(String userid, String password) {
		super();
		this.userid = userid;
		this.password = password;
	}

	public Login() {
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [userid=" + userid + ", password=" + password + "]";
	}

}
