package com.nagarro.dao;

import com.nagarro.models.User;
import com.nagarro.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class AuthDao  {
	private static final String USERNAMEQUERY="from User where username='";
	private static final String PASSWORDQUERY="' and password='";
	
	public boolean isAuthUser(User user) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			Transaction t=session.beginTransaction();
			StringBuilder query=new  StringBuilder();
			query.append(USERNAMEQUERY+user.getUsername());
			query.append(PASSWORDQUERY+user.getPassword()+"'");
			User isUser=session.createQuery(query.toString(),User.class).uniqueResult();
			t.commit();
			return isUser!=null && isUser.getUsername().equals(user.getUsername());
		}
	}

}
