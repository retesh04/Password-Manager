package com.bellinfo.password.model;

public class Delete {
	String nameType;
	String userid;
	String password;
	Integer id;

	public Delete(String nameType, String userid, String password, Integer id) {
		super();
		this.nameType = nameType;
		this.userid = userid;
		this.password = password;
		this.id = id;
	}

	public Delete() {
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
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
		return "Delete [nameType=" + nameType + ", userid=" + userid + ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
