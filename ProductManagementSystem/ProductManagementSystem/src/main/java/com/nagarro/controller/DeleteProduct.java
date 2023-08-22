package com.nagarro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.ProductDao;

public class DeleteProduct extends HttpServlet {

	private static final long serialVersionUID = -774478492760360861L;
	private final ProductDao pd;

	public DeleteProduct() {
		this.pd = new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pd.deleteProduct(id);
		response.sendRedirect("../");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
