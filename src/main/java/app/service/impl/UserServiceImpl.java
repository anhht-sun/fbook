package app.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import app.model.User;
import app.service.UserService;



public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User findById(Serializable key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveOrUpdate(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUsers(String name, int gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
