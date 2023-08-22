package com.training.nagarro.dao;
import java.util.List;

import com.training.nagarro.model.TShirt;

/**
 *
 */
public interface TShirtDao {
	/**
	 * @param tshirt
	 * @return status
	 */
	int insertTshirt(TShirt tshirt);
	/**
	 * @return alltshirts
	 */
	List <TShirt> getAllTShirt();
	
	/**
	 * @param tshirt
	 * @return list
	 */
	List <TShirt> getFilteredTShirt(TShirt tshirt);
	
}
