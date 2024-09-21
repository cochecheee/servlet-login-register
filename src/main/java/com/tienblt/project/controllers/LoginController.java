package com.tienblt.project.controllers;

import java.io.IOException;

import com.tienblt.project.models.UserModel;
import com.tienblt.project.services.IUserService;
import com.tienblt.project.services.impl.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6821845399286299911L;
	
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";

	// Lấy toàn bộ hàm trong service
	IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
		  rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy tham số từ view
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		System.out.println(username);
		// kiểm tra tham số
		boolean isRememberMe = false;
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		// Xử lý bài toán
		UserModel user = service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}

	}

	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		resp.addCookie(cookie);
	}
}
