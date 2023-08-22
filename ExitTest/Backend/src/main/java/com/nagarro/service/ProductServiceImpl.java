package com.nagarro.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.nagarro.dao.ProductRepository;
import com.nagarro.exception.ResourceNotFoundException;
import com.nagarro.model.Filter;
import com.nagarro.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductRepository repo;

	@Override
	public ResponseEntity<Product> getProductById(int Id) {
		Product prod = repo.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Product doesnot exixt with id :" + Id));
		return ResponseEntity.ok(prod);
	}

	@Override
	public Product adddProduct(Product Product) {

		return repo.save(Product);
	}

	@Override
	public ResponseEntity<Product> updateProduct(int id, Product prodDetails) {
		Product prod = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product doesnot exixt with id :" + id));
		prod.setId(prodDetails.getId());
		prod.setBrand(prodDetails.getBrand());
		prod.setDescr(prodDetails.getDescr());
		prod.setImage(prodDetails.getImage());
		prod.setPrice(prodDetails.getPrice());
		prod.setTitle(prodDetails.getTitle());
		Product updatedProd = repo.save(prod);
		return ResponseEntity.ok(updatedProd);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteProduct(int id) {
		Product prod = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product doesnot exixt with id :" + id));
		repo.delete(prod);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
	public List<Product> getAllProduct(Filter filter) {
		if (!Objects.isNull(filter)) {
			if (filter.getSearch() == null)
				filter.setSearch("");
			if (filter.getPrice() != null) {

				if (filter.getPrice().equals("desc"))
					return repo.findByFilterDesc(filter.getSearch());
			}
			return repo.findByFilterAsc(filter.getSearch());
		}
		return repo.findAll();
	}

}
