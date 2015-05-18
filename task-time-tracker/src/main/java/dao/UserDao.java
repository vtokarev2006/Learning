package dao;

import java.util.List;

import model.User;

public interface UserDao extends GenericDao<User, String> {
	
	public List<User> findAll();
	public User findByUsernamePassword(String username, String password);
	public User findByUsername(String username);	
	public User findByEmail(String email);
	
	
	

}
