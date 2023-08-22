package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.ProductDao;
import com.nagarro.models.Product;

public class EditProduct extends HttpServlet {

	private static final long serialVersionUID = -4178976235407224207L;
	private final ProductDao pd;

	public EditProduct() {
		this.pd = new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = pd.getProduct(id);
		session.setAttribute("editProductDetail", product);
		RequestDispatcher rd = request.getRequestDispatcher("./edit");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
