package com.bellinfo.hibernate.password;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GetSession gs = new GetSession();
		SessionFactory sf = gs.newSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Tab1 tb = new Tab1("vishal", "vishal@abc.com", "vishal123", "vishal");
		Tab2 tb1 = new Tab2("vishal123", "Banking", "BOFA", "vishal456", "abcd1234");
		Tab2 tb2 = new Tab2("vishal123", "SocialMedia", "FB", "vishal896", "abcd@1234");
		session.save(tb);
		session.save(tb1);
		session.save(tb2);
		transaction.commit();
		session.close();
		sf.close();
	}

}
