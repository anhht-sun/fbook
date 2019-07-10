package app.service.impl;

import app.dao.UserDAO;

public class BaseServiceImpl {
	protected UserDAO userDAO;

	public UserDAO getStudentDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}