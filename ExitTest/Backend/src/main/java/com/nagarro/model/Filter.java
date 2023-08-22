package com.nagarro.model;

public class Filter {
	String search;
	String price;
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Filter(String search, String price) {
		super();
		this.search = search;
		this.price = price;
	}
	public Filter() {
		super();
	}
}

