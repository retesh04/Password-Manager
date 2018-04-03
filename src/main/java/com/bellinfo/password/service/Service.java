package com.bellinfo.password.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellinfo.password.model.Ecom;
import com.bellinfo.password.model.Edit;
import com.bellinfo.password.model.GeneratePassword;
import com.bellinfo.password.model.Login;
import com.bellinfo.password.model.Registration;
import com.bellinfo.password.model.SocialMedia;
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

	public void storeSocial(SocialMedia sm, String user) throws SQLException {
		repo.socialDetails(sm, user);
	}

	public void storeEcom(Ecom em, String user) throws SQLException {
		repo.EcomDetails(em, user);
	}

	public List<GeneratePassword> bankView(GeneratePassword gp, String user) throws Exception {
		return repo.bankView(gp, user);
	}

	public Edit getRec(int id) {
		return repo.getRecord(id);
	}

	public String updateRec(Edit edit1) {
		return repo.updateRecord(edit1);
	}

	public void update(Edit edit) {

		repo.updateRecord(edit);
	}
	
	public String delete(int id) {

		return repo.deleteRecord(id);
	}

}