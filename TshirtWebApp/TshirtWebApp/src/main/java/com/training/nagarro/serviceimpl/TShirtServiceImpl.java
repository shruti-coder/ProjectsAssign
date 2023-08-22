package com.training.nagarro.serviceimpl;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.training.nagarro.dao.TShirtDao;
import com.training.nagarro.model.TShirt;
import com.training.nagarro.service.TShirtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TShirtServiceImpl implements TShirtService {
	private final TShirtDao ts;

	@Autowired
	public TShirtServiceImpl(@Qualifier("TShirtDaoImpl") TShirtDao tshirtDao) {
		this.ts = tshirtDao;
	}

	/**
	 * @param tshirt
	 * @return status
	 */
	
	public int insertTShirt(TShirt tshirt) {
		return ts.insertTshirt(tshirt);
	}

	/**
	 * @return all tshirts to tshirt controller
	 */
	
	public List<TShirt> getAllTShirt() {
		return ts.getAllTShirt();
	}

	private List<TShirt> sortingList(List<TShirt> list, Comparator<TShirt> comp) {
		return list.stream().sorted(comp).collect(Collectors.toList());
	}

	/**
	 * @param outputpreference
	 * @return sorted Tshirt
	 */
	
	public List<TShirt> sortedTShirts(TShirt tshirt, String outputPreference) {
		List<TShirt> list = ts.getFilteredTShirt(tshirt);
		List<TShirt> sortedList;
		switch (outputPreference.toLowerCase()) {

		// sorting based on rating
		case "rating":
			Comparator<TShirt> c = Comparator.comparingDouble(TShirt::getRating).reversed();
			sortedList = sortingList(list, c);
			break;

		// sorting based on price
		case "price":
			Comparator<TShirt> c1 = Comparator.comparingDouble(TShirt::getPrice);
			sortedList = sortingList(list,c1);
			break;

		// sorting based on both
		case "both":
			Comparator<TShirt> c2=Comparator.comparingDouble(TShirt::getRating).reversed();
			sortedList = sortingList(list,c2);
			break;
		default:
			sortedList = list;
			break;
		}
		return sortedList;
	}

}
