package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.UserDao;

public abstract class AbstractService {

	final protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected UserDao userDao;

	protected final String USER_INVALID = "Not a valid user";
	protected final String USER_NOT_ADMIN = "Not an admin user";

	protected boolean isValidUser(String username) {
		
		return (userDao.findByUsername(username) == null) && (userDao.findByEmail(username) == null) ? false : true;
	}
	
	protected boolean isAdmin(String username){
		if (isValidUser(username)){
			return userDao.findByUsername(username).isAdmin() || userDao.findByEmail(username).isAdmin() ;
		} else {
			return false;
		}
	}

}
