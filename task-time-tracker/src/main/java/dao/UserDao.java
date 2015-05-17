package dao;

import java.util.List;

import model.User;

public interface UserDao extends GenericDao<User, String> {
	
	public List<User> findAll();
	public User findByUsernamePassword(String username, String Password);
	public User findByEmail(String email);
	
	
	

}
