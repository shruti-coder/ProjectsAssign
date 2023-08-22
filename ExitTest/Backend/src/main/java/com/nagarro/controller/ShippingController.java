package com.nagarro.controller;

import com.nagarro.model.Shipping;
import com.nagarro.service.ShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*" )
@RestController
@RequestMapping("/")
public class ShippingController {
@Autowired
private ShippingService service;

@GetMapping("/shipDetails/{pincode}")
public ResponseEntity<Shipping>getShipping(@PathVariable int pincode){
	return ResponseEntity.ok(service.getShipDetails(pincode));
}
}
