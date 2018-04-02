package com.bellinfo.password.model;

public class StoreBankDetails {

	String bankName;
	String userid;
	String password;
	String url;

	public StoreBankDetails(String bankName, String userid, String password, String url) {
		super();
		this.bankName = bankName;
		this.userid = userid;
		this.password = password;
		this.url = url;
	}

	public StoreBankDetails() {
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

}
