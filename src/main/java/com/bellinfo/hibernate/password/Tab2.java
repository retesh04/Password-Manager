package com.bellinfo.hibernate.password;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Tab2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;

	@Column(name = "userid")
	String userid;
	@Column(name = "accountType")
	String accountType;
	@Column(name = "nameType")
	String nameType;
	@Column(name = "childUserId")
	String childUserId;
	@Column(name = "childPass")
	String childPassword;

	public Tab2(String userid, String accountType, String nameType, String childUserId, String childPassword) {
		super();
		this.userid = userid;
		this.accountType = accountType;
		this.nameType = nameType;
		this.childUserId = childUserId;
		this.childPassword = childPassword;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getChildUserId() {
		return childUserId;
	}

	public void setChildUserId(String childUserId) {
		this.childUserId = childUserId;
	}

	public String getChildPassword() {
		return childPassword;
	}

	public void setChildPassword(String childPassword) {
		this.childPassword = childPassword;
	}

}
