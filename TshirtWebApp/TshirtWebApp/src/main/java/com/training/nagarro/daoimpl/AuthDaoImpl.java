package com.training.nagarro.daoimpl;

import javax.transaction.Transactional;

import com.training.nagarro.dao.AuthDao;
import com.training.nagarro.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * AuthDaoImpl
 */
@Repository
public class AuthDaoImpl implements AuthDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/* (non-Javadoc)
	 * @see com.training.nagarro.dao.AuthDao#registerUser(com.training.nagarro.model.User)
	 */
	@Transactional
	@Override
	public int registerUser(User user) {
		Session registerSession=getSessionFactory().getCurrentSession();
		registerSession.save(user);
		return 1;
	}

	/* (non-Javadoc)
	 * @see com.training.nagarro.dao.AuthDao#isAuthenticated(com.training.nagarro.model.User)
	 */
	@Transactional
	@Override
	public boolean isAuthenticated(User user) {
		Session isAuthenticated=getSessionFactory().getCurrentSession();
		User userDb=isAuthenticated.get(User.class, user.getUsername());
		return userDb.getPassword().equals(user.getPassword());
	}

}
