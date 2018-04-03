package com.bellinfo.hibernate.password;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Tab1 {
	
	@Id
	@Column(name="userid")
	String userid;
	
	@Column(name="name")
	String name;
	@Column(name="password")
	String password;
	@Column(name="email")
	String email;
	
	@OneToMany
	@JoinColumn(name="userid",foreignKey=@ForeignKey(name="userid"))
	Collection<Tab2> t2=new ArrayList<Tab2>();
	
	
	public Collection<Tab2> getT2() {
		return t2;
	}
	public void setT2(Collection<Tab2> t2) {
		this.t2 = t2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
		public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Tab1(String name, String email, String userid, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password=password;
		this.userid = userid;
	}
	public Tab1() {
		
	}

}
