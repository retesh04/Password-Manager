package com.bellinfo.password.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Registration {

	@NotEmpty
	@NotNull
	@Size(min = 4, max = 10)
	String userid;
	@NotEmpty
	@NotNull
	String password;
	@NotEmpty
	@NotNull
	String email;
	String name;

	public Registration(String userid, String password, String email, String name) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public Registration() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
