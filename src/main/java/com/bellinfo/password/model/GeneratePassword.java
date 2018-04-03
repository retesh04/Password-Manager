package com.bellinfo.password.model;

public class GeneratePassword {

	String userid;
	String password;
	String accountType;
	String nameType;
	int id;

	public GeneratePassword(String userid, String password, String accountType, String nameType, int id) {
		super();
		this.userid = userid;
		this.password = password;
		this.accountType = accountType;
		this.nameType = nameType;
		this.id = id;
	}

	public GeneratePassword() {
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "[" + "Passwords: " + "Userid is: " + userid + "The password is: " + password + " The account type is: "
				+ accountType + "The name type is:" + nameType + "]";
	}
}
