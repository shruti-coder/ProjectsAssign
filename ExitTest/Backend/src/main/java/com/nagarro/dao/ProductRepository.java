package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.brand LIKE %:search% order by p.price desc")
	List<Product> findByFilterDesc(String search);
	@Query("select p from Product p where p.brand LIKE %:search% order by p.price")
	List<Product> findByFilterAsc(String search);
}
