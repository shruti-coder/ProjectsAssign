package com.nagarro.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.ProductDao;
import com.nagarro.models.Product;

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = -8510698854998612475L;
	private final ProductDao pd;

	public AddProduct() {
		this.pd = new ProductDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = new Product();
		product.setProductTitle(request.getParameter("title").trim());
		product.setProductSize(Integer.parseInt(request.getParameter("size").trim()));
		product.setProductQuantity(Integer.parseInt(request.getParameter("quantity").trim()));
		product.setProductImage(new File(request.getParameter("image")).getAbsolutePath());
		pd.addProduct(product);
		response.sendRedirect("./Products");
	}


	public List<Product> getAllProduct() {
		return pd.getAllProduct();
	}
}
