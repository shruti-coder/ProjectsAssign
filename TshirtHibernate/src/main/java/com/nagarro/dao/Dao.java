package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Tshirt;
import com.nagarro.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Dao {

	public void insertTshirt(Tshirt tshirt) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction insertTransaction = session.beginTransaction();
		session.merge(tshirt);
		insertTransaction.commit();
	}
	
	public List<Tshirt> getTshirt(Tshirt tshirt,String output)
	{
		System.out.println(tshirt);
		String queryToExec="from Tshirt where colour='"+tshirt.getColour()+"' and size='"+tshirt.getSize()+"' and genderRecommendation='"+tshirt.getGenderRecommendation()+"' order by " + checkOut(output);
		Session session = HibernateUtil.getSession().openSession();
		Transaction insertTransaction = session.beginTransaction();
		List <Tshirt> tshirts=session.createQuery(queryToExec, Tshirt.class).getResultList();
		insertTransaction.commit();
		
		return tshirts;
	}
	
	public String checkOut(String output) {
		switch (output.toLowerCase()) {
			case "price":
				return "price";
			case "rating":
				return "rating desc";
			case "both":
				return "price";
				

			default:
				return "price";
		}
	}
}
