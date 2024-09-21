package com.tienblt.project.services.impl;

import com.tienblt.project.dao.IUserDao;
import com.tienblt.project.dao.impl.UserDaoImpl;
import com.tienblt.project.models.UserModel;
import com.tienblt.project.services.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	// Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			IUserService userService = new UserServiceImpl();

			System.out.println(userService.login("tienbui", "123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean register(String username, String email, String password, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, 3, phone, date));
		return true;
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);

	}

	@Override
	public void updatePassword(String username, String password) {
		userDao.updatePassword(username, password);
	}
}
