package com.tienblt.project.controllers;

import java.io.IOException;

import com.tienblt.project.services.IUserService;
import com.tienblt.project.services.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPasswordController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2107824276639798482L;

	private static final String FORGOT_PASSWORD = "/views/forgotPassword.jsp";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(FORGOT_PASSWORD).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String alertMsg = "";
		IUserService service = new UserServiceImpl();
		if (service.checkExistUsername(username)) {
			service.updatePassword(username, password);
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			alertMsg = "Username không tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(FORGOT_PASSWORD).forward(request, response);
		}
	}
}
