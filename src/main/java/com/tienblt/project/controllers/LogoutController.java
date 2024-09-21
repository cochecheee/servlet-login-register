package com.tienblt.project.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1366248548188082493L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		Cookie cookie = null;
		Cookie[] cookies = null;
		// Get an array of Cookies associated with this domain
		cookies = req.getCookies();
		// Set response content type
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("username") == 0) {
					// delete cookie
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
