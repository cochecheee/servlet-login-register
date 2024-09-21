package com.tienblt.project.controllers;

import java.io.IOException;

import com.tienblt.project.services.IUserService;
import com.tienblt.project.services.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7194911657498807595L;
	public static final String REGISTER = "/views/register.jsp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  HttpSession session = request.getSession(false); if (session != null &&
		  session.getAttribute("username") != null) {
		  response.sendRedirect(request.getContextPath() + "/admin/home"); return; }
		  Cookie[] cookies = request.getCookies(); if (cookies != null) { for (Cookie
		  cookie : cookies) { if (cookie.getName().equals("username")) { session =
		  request.getSession(true); session.setAttribute("username",
		  cookie.getValue()); response.sendRedirect(request.getContextPath() +
		  "/admin/home"); return; } } }
		 
		//chua co nut logout xoa session, cmmt doan code tren moi ra lai trang register
		request.getRequestDispatcher(REGISTER).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		IUserService service = new UserServiceImpl();
		String alertMsg = "";
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(REGISTER).forward(request, response);
			return;
		}
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(REGISTER).forward(request, response);
			return;
		}
		boolean isSuccess = service.register(username, email, password, fullname, phone);
		if (isSuccess) {
			request.setAttribute("alert", alertMsg);
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			request.setAttribute("alert", alertMsg);
			request.getRequestDispatcher(REGISTER).forward(request, response);
		}
	}
}
