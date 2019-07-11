package app.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.model.User;

@Repository
public interface UserService extends BaseService<Integer, User> {
	boolean deleteUser(Integer id);

	User findByEmail(String email);

	List<User> searchUsers(String name, int gender);

	List<User> loadUsers();
}