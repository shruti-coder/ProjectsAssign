package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	 public class Product {
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private int id ;
	 	private String title;
	 	private int price;
	 	private String descr;
	 	private String brand;
	 	private String image;
	 	public int getId() {
	 		return id;
	 	}
	 	public void setId(int id) {
	 		this.id = id;
	 	}
	 	public String getTitle() {
	 		return title;
	 	}
	 	public void setTitle(String title) {
	 		this.title = title;
	 	}
	 	public int getPrice() {
	 		return price;
	 	}
	 	public void setPrice(int price) {
	 		this.price = price;
	 	}
	 	public String getDescr() {
	 		return descr;
	 	}
	 	public void setDescr(String desc) {
	 		this.descr = desc;
	 	}
	 	public String getBrand() {
	 		return brand;
	 	}
	 	public void setBrand(String brand) {
	 		this.brand = brand;
	 	}
	 	public String getImage() {
	 		return image;
	 	}
	 	public void setImage(String image) {
	 		this.image = image;
	 	}
	 	public Product(int id, String title, int price, String desc, String brand, String image) {
	 		super();
	 		this.id = id;
	 		this.title = title;
	 		this.price = price;
	 		this.descr = desc;
	 		this.brand = brand;
	 		this.image = image;
	 	}
	 	public Product() {
	 		super();
	 	}
}
