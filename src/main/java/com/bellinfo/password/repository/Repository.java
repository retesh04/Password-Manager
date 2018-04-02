package com.bellinfo.password.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bellinfo.password.model.GeneratePassword;
import com.bellinfo.password.model.Login;
import com.bellinfo.password.model.Registration;
import com.bellinfo.password.model.StoreBankDetails;

@Component
public class Repository {
	@Autowired
	JdbcTemplate jdbctemplate;

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public void RegistrationDetails(Registration reg) throws SQLException {
		jdbctemplate.update("insert into tab1(userid,password,email,name) values(?,?,?,?)", reg.getUserid(),reg.getPassword(),reg.getEmail(),reg.getName());
		System.out.println("Inserted Successfully");
	}
	
	public String verify(Login log) {
		String user = log.getUserid();
		String pass = log.getPassword();
		System.out.println("**************");
		System.out.println(user);
		System.out.println(pass);
		String name1 = "";
		try {
			log = jdbctemplate.queryForObject("select * from tab1 where userid=?", new Object[]{user},
					new RowMapper<Login>() {

						public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
							Login log = new Login();
							log.setUserid(rs.getString("userid"));
							log.setPassword(rs.getString("password"));
							return log;
						}
				
					});
			System.out.println(log);
			if(user.equals(log.getUserid())&&pass.equals(log.getPassword())) {
				name1 = "The User Credentials are verified";
				System.out.println(name1);
			}else {
				name1 = "No user record found";
				System.out.println(name1);
			}
			
		} catch (Exception e) {
			return "No user Record is found";
		}
		
		return name1;
		
	}
	
	
	public void bankDetails(StoreBankDetails sbd,String user) throws SQLException {
		jdbctemplate.update("insert into tab2(accounttype,childuserid,childpass,nametype,userid) values(?,?,?,?,?)", "Banking",sbd.getUserid(),sbd.getPassword(),sbd.getBankName(),user);
		System.out.println("Inserted Successfully");
	}
	
	public List<GeneratePassword> bankView(GeneratePassword gp,String user) throws Exception {
		System.out.println(user);
		List<GeneratePassword> list1 = new ArrayList<GeneratePassword>();
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://bellinfo.c3rbut2zylxn.us-east-1.rds.amazonaws.com:5432/Bellinfo", "rahmath8121",
				"Intern8121!");
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM tab2 where userid=?");
		stmt.setString(1, user);
		ResultSet query_set = stmt.executeQuery();
		System.out.println(query_set);
		while(query_set.next()) {
			String userid = query_set.getString("childuserid");
			String password = query_set.getString("childpass");
			String accountType = query_set.getString("accounttype");
			String nameType = query_set.getString("nametype");
			gp = new GeneratePassword(userid, password, accountType, nameType);
			
			list1.add(gp);
		}
	return list1;
}
	
	public void deleteTeam(int id) {
		GeneratePassword gp = new GeneratePassword();
		
		if(gp != null){
			
		}
		
	}
}
	
