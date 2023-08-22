package com.nagarro.service;

import com.nagarro.dao.ShippingRepository;
import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.Shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShippingServiceImpl implements ShippingService {
	
	@Autowired
	private ShippingRepository repo;

	@Override
	public Shipping getShipDetails(int pincode) {
		Shipping details = repo.findById(pincode).
				orElseThrow(()->new ResourceNotFoundException("Delivery not possible with this pincode :"+pincode));
		return details;
	}

}
