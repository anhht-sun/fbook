package app.dao;

import java.util.List;

import app.model.User;



public interface UserDAO extends BaseDAO<Integer, User> {
	User findByEmail(String email);

	List<User> searchUserUsingCretial(String name, int gender);

	List<User> loadUsers();
	
	

}