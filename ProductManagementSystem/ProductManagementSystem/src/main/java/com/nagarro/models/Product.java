package com.nagarro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Product Bean
 */
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pId",nullable= false)
    private int productId;

    @Column(name="pTitle")
    private String productTitle;
    
    @Column(name="pQuantity")
    private int productQuantity;
    
    @Column(name="pSize")
    private int productSize;
    
    @Column(name="pImage")
    private String productImage;

    public Product() {
    }

	/**
	 * @return productid
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return product title
	 */
	public String getProductTitle() {
		return productTitle;
	}

	/**
	 * @param productTitle
	 */
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	/**
	 * @return product quantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return product size
	 */
	public int getProductSize() {
		return productSize;
	}

	/**
	 * @param productSize
	 */
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	/**
	 * @return product image
	 */
	public String getProductImage() {
		return productImage;
	}

	/**
	 * @param productImage
	 */
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	/**
	 * @param productId
	 * @param productTitle
	 * @param productQuantity
	 * @param productSize
	 * @param productImage
	 */
	public Product(int productId, String productTitle, int productQuantity, int productSize, String productImage) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productQuantity = productQuantity;
		this.productSize = productSize;
		this.productImage = productImage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", productQuantity="
				+ productQuantity + ", productSize=" + productSize + ", productImage=" + productImage + "]";
	}

	
    
}
