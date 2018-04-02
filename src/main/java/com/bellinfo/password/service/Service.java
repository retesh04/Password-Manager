package com.bellinfo.password.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellinfo.password.model.GeneratePassword;
import com.bellinfo.password.model.Login;
import com.bellinfo.password.model.Registration;
import com.bellinfo.password.model.StoreBankDetails;
import com.bellinfo.password.repository.Repository;


@Component
public class Service {

	@Autowired
	Repository repo;

	public void setRepo(Repository repo) {
		this.repo = repo;
	}

	public void Register(Registration reg) throws SQLException {
		repo.RegistrationDetails(reg);
	}

	public String validation(Login log) {
		String str = repo.verify(log);
		return str;
	}

	public void storeBank(StoreBankDetails sbd, String user) throws SQLException {
		repo.bankDetails(sbd, user);
	}

	public List<GeneratePassword> bankView(GeneratePassword gp, String user) throws Exception {
		return repo.bankView(gp, user);
	}

	public void deleteTeam(Integer id) {
		// TODO Auto-generated method stub
		
	}

}