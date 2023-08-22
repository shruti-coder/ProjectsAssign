package com.nagarro.utils;

import com.nagarro.models.Product;
import com.nagarro.models.User;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private HibernateUtil() {
	}

	private static SessionFactory sessionFactory;

	/**
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				configuration.configure();
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Product.class);
				// local SessionFactory bean created
				sessionFactory = configuration.buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
