package com.training.nagarro.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import com.training.nagarro.dao.TShirtDao;
import com.training.nagarro.model.TShirt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository("TShirtDaoImpl")
public class TshirtDaoImpl implements TShirtDao {
	private static final String TSHIRTCOLOUR = "from TShirt where colour='";
	private static final String TSHIRTGENDER = "' and gender='";
	private static final String TSHIRTSIZE = "'and size='";
	/**
	 * inserting data to Database
	 */

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Transactional
	public int insertTshirt(TShirt tshirt) {
		System.out.println(tshirt);
		Session insertTshirt = getSessionFactory().getCurrentSession();
		insertTshirt.merge(tshirt);
		return 1;
	}

	/**
	 * @return all T-shirt list
	 */
	@Transactional
	public List<TShirt> getAllTShirt() {
		Session getAllTShirt = getSessionFactory().getCurrentSession();
		return getAllTShirt.createQuery("from TShirt", TShirt.class).getResultList();
	}

	/**
	 * @param tshirt
	 * @param outputPreference
	 * @return filtered Tshirt
	 */

	@Transactional
	public List<TShirt> getFilteredTShirt(TShirt tshirt) {
		Session getAllTShirt = getSessionFactory().getCurrentSession();
		StringBuilder query = new StringBuilder();
		query.append(TSHIRTCOLOUR + tshirt.getColour());
		query.append(TSHIRTGENDER + tshirt.getGender());
		query.append(TSHIRTSIZE + tshirt.getSize() + "'");
		return getAllTShirt.createQuery(query.toString(), TShirt.class).getResultList();
	}
}
