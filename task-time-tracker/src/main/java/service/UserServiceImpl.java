package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vo.Result;
import vo.ResultFactory;
import dao.TaskLogDao;
import domain.User;

@Transactional
@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService {
	
	@Autowired
	TaskLogDao taskLogDao;
	
	UserServiceImpl(){
		super();
		
	}
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<User> store(String username, String firstName, String lastName, String email, String password, Character adminRole, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
        if (username == null || username.trim().isEmpty() || email == null || email.trim().isEmpty() ) {
            return ResultFactory.getFailResult("Unable to store a user without a valid non empty username/email");
        }
			
        if(password == null || password.length() == 0){
            return ResultFactory.getFailResult("Unable to store a user without a valid non empty password");
        }
        
        if(!adminRole.equals('Y') && !adminRole.equals('N')){
            return ResultFactory.getFailResult("Unable to store the user: adminRole must be Y or N");
        }
        
        username = username.trim().toLowerCase();
        email = email.trim().toLowerCase();
        
        
		User user = userDao.findByUsername(username);
		User testByEmailUser = userDao.findByEmail(email);
		
		boolean insert = true;
		
		
		if (user==null){
			
			if (testByEmailUser != null) {
				return ResultFactory.getFailResult("Unable to add new user: the email address is already in use");
			}
			
			user = new User();
			user.setUsername(username);
			
			
		} else {
			
			if ((testByEmailUser!=null) && !user.equals(testByEmailUser)) {
				return ResultFactory.getFailResult("The email address is already in use by username=" + testByEmailUser.getUsername() + "and cannot be assigned to " + username);
			}
			
			insert = false;
		}
		
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAdminRole(adminRole);
		
		if (insert) {
			userDao.persist(user);
		} else {
			userDao.merge(user);
		}
		
		return ResultFactory.getSuccessResult(user);
	}

	
	
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<User> remove(String username, String actionUsername) {

		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
		if (username == null)
            return ResultFactory.getFailResult("Unable to remove null User");
		
		User user = userDao.findByUsername(username);
		
		if (user==null)
			return ResultFactory.getFailResult("Unable to load user for removal with username=" + username);
		
		
		if(taskLogDao.findTaskLogCountByUser(user) > 0)
			return ResultFactory.getFailResult("Unable to remove User with username=" + username + " as valid task logs are assigned");
		
		userDao.remove(user);
		String msg = "User " + username + " was deleted by " + actionUsername;
		logger.info(msg);
		return ResultFactory.getSuccessResultMsg(msg);
		
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<User> find(String username, String actionUsername) {
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		User user = userDao.find(username);
		
		return ResultFactory.getSuccessResult(user);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<List<User>> findAll(String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		List<User> users = userDao.findAll();
		
		return ResultFactory.getSuccessResult(users);
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<User> findByUsernamePassword(String username, String password) {
		
		if (!isValidUser(username))
			return ResultFactory.getFailResult(USER_INVALID);
		
        User user = userDao.findByUsernamePassword(username, password);

        if(user == null)
        	return ResultFactory.getFailResult("Unable to verify user/password combination!");

        return ResultFactory.getSuccessResult(user);
	}

}
