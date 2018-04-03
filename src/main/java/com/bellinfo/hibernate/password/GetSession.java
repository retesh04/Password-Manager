package com.bellinfo.hibernate.password;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class GetSession {
	public static SessionFactory newSessionFactory() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
		properties.put("hibernate.connection.url", "jdbc:postgresql://localhost/postgres");
		properties.put("hibernate.connection.username", "postgres");
		properties.put("hibernate.connection.password", "Welcome12#");
		properties.put("hibernate.default_schema", "public");


		return new Configuration().addProperties(properties).addAnnotatedClass(Tab1.class)
				.addAnnotatedClass(Tab2.class)
				.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(properties).build());
	}

}
