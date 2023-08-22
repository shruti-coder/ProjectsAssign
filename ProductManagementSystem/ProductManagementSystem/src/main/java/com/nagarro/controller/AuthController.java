package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.AuthDao;
import com.nagarro.models.User;


/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1023239L;

	public AuthController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		User checkUsr = new User();
		checkUsr.setUsername(request.getParameter("username"));
		checkUsr.setPassword(request.getParameter("password"));
		AuthDao service = new AuthDao();
		if (service.isAuthUser(checkUsr)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", checkUsr.getPassword());
			response.sendRedirect("./Products");
		} else {
			request.setAttribute("errMsg", "Invalid Username or Password");
			response.sendRedirect("./");
		}

	}

}
