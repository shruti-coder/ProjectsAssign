package com.nagarro.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.ProductDao;
import com.nagarro.models.Product;

public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final ProductDao pd;
    public UpdateProduct() {
        this.pd=new ProductDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Product edit = (Product) session.getAttribute("editProductDetail");
		Product product = new Product();
		product.setProductId(edit.getProductId());
		product.setProductTitle(request.getParameter("title").trim());
		product.setProductSize(Integer.parseInt(request.getParameter("size").trim()));
		product.setProductQuantity(Integer.parseInt(request.getParameter("quantity").trim()));
		product.setProductImage(new File(request.getParameter("image")).getAbsolutePath());
		pd.updateProduct(product);
		response.sendRedirect("../");
	}

}
