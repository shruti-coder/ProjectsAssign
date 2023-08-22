package com.training.nagarro.service;

import java.util.List;

import com.training.nagarro.model.TShirt;

public interface TShirtService {
	/**
	 * @param tshirt
	 * @return status
	 */
	int insertTShirt(TShirt tshirt);

	/**
	 * @param tshirt
	 * @return status
	 */
	List<TShirt> getAllTShirt();

	/**
	 * @param outputPreference
	 * @return list
	 */
	List<TShirt> sortedTShirts(TShirt tshirt,String outputPreference);
}
