package com.nagarro.utils;

import com.nagarro.model.Tshirt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Tshirt.class);
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}
}
