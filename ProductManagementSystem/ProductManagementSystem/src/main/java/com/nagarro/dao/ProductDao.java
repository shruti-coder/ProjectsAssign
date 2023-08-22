package com.nagarro.dao;

import java.util.List;

import com.nagarro.models.Product;
import com.nagarro.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDao {

	public int addProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction addProduct = session.beginTransaction();
			session.merge(product);
			addProduct.commit();
		}
		return 0;
	}

	public List<Product> getAllProduct() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction getAllProducts = session.beginTransaction();
			List<Product> productsList = session.createQuery("from Product", Product.class).getResultList();
			getAllProducts.commit();
			return productsList;
		}
	}

	public Product getProduct(int productId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction getProduct = session.beginTransaction();
			Product product = session.createQuery("from Product where id=" + productId, Product.class)
					.getSingleResult();
			getProduct.commit();
			return product;
		}
	}

	public int updateProduct(Product product) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction updateProducts = session.beginTransaction();
			Product productFromDb = session.get(Product.class, product.getProductId());
			productFromDb.setProductTitle(product.getProductTitle());
			productFromDb.setProductQuantity(product.getProductQuantity());
			productFromDb.setProductSize(product.getProductSize());
			productFromDb.setProductImage(product.getProductImage());
			updateProducts.commit();
			return 1;
		}
	}

	public int deleteProduct(int productId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction deleteProduct = session.beginTransaction();
			Product productToDelete = session.get(Product.class, productId);
			session.remove(productToDelete);
			deleteProduct.commit();
		}
		return 0;
	}

}
