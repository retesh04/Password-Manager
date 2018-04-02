package com.bellinfo.password.model;

public class Ecom {

	String ecomName;
	String userid;
	String password;
	String url;

	public String getEcomName() {
		return ecomName;
	}

	public void setEcomName(String ecomName) {
		this.ecomName = ecomName;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Ecom(String ecomName, String userid, String password, String url) {
		super();
		this.ecomName = ecomName;
		this.userid = userid;
		this.password = password;
		this.url = url;
	}

	public Ecom() {

	}

}
