package com.prowings;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			return sessionFactory;
		} else
			return sessionFactory;

	}

	public static void shutDown() {
		sessionFactory.close();
	}

}
