package com.nagarro.controller;

import java.util.List;
import java.util.Map;

import com.nagarro.model.Filter;
import com.nagarro.model.Product;
import com.nagarro.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	public ProductService service;
	
	
	
	@GetMapping("/products")
	public List<Product> getProduct(@RequestParam(name ="search",required = false) String search,
			@RequestParam(name="price",required=false) String price){
		Filter filter=new Filter();
		if(search!=null)
			filter.setSearch(search);
		if(price!=null)
			filter.setPrice(price);
	   return service.getAllProduct(filter);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProdById(@PathVariable int id){
		return service.getProductById(id);
	}
	
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product Product) {
		return service.adddProduct(Product);
	}
	
	@PutMapping("products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product prodDetails){
		return service.updateProduct(id, prodDetails);
	}
	
	@DeleteMapping("products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(int id){
		return service.deleteProduct(id);
	}
}

