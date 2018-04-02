package com.bellinfo.password.model;

public class SocialMedia {
	String SmName;
	String userid;
	String password;
	String url;

	public String getSmName() {
		return SmName;
	}

	public void setSmName(String smName) {
		SmName = smName;
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

	public SocialMedia(String smName, String userid, String password, String url) {
		super();
		SmName = smName;
		this.userid = userid;
		this.password = password;
		this.url = url;
	}

	public SocialMedia() {

	}

}
