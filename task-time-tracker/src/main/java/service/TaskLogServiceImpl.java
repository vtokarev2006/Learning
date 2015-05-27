package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vo.Result;
import vo.ResultFactory;
import dao.TaskDao;
import dao.TaskLogDao;
import domain.Task;
import domain.TaskLog;
import domain.User;

@Transactional
@Service("taskLogService")
public class TaskLogServiceImpl extends AbstractService implements TaskLogService  {
	
	@Autowired
	TaskLogDao taskLogDao;
	
	@Autowired
	TaskDao taskDao;
	
	
	
	TaskLogServiceImpl(){
		super();
	}
	

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public Result<TaskLog> store(Integer taskLogId, Integer taskId,	String username, String taskDescription, Date taskLogDate, int taskMinutes, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		
        if(taskId == null)
            return ResultFactory.getFailResult("Unable to store task log with null taskId");
		
        if(username == null)
            return ResultFactory.getFailResult("Unable to store task log with null username");
        
        if(taskLogDate == null)
            return ResultFactory.getFailResult("Unable to store task log with null taskLogDate");
        
		
        Task task = taskDao.find(taskId);
        
        if(task == null)
            return ResultFactory.getFailResult("Unable to store task log with taskId=" + taskId);
        
		User user = userDao.findByUsername(username);
        if(user == null)
            return ResultFactory.getFailResult("Unable to store task log with username="+username);
		
        if (!isAdmin(actionUsername) || !actionUsername.equals(username) ) 
			return ResultFactory.getFailResult("User performing save must be an admin user or saving their own record");
        
        
        TaskLog taskLog;
        
        if (taskLogId==null) {
        	taskLog = new TaskLog();
        	
        } else {
        	
        	taskLog = taskLogDao.find(taskLogId);
        	if (taskLog==null)
        		return ResultFactory.getFailResult("Unable to find taskLog instance with ID=" + taskLogId);
        	
        }

        
        taskLog.setDescription(taskDescription);
        taskLog.setTaskDate(taskLogDate);
        taskLog.setTaskMinutes(taskMinutes);
        taskLog.setTask(task);
        taskLog.setUser(user);

        if(taskLog.getId() == null) {
        	taskLogDao.persist(taskLog);
        } else {
        	taskLog = taskLogDao.merge(taskLog);
        }

        return ResultFactory.getSuccessResult(taskLog);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public Result<TaskLog> remove(Integer taskLogId, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
		if (taskLogId==null) 
			return ResultFactory.getFailResult("Unable remove TaskLog record with [taskLogId=null]");
		
		TaskLog taskLog = taskLogDao.find(taskLogId);
		
		if (taskLog==null) 
			return ResultFactory.getFailResult("Unable to load TaskLog for removal with idTaskLog=" + taskLogId);
		
		
		taskLogDao.remove(taskLog);
        return ResultFactory.getSuccessResultMsg("taskLog removed successfully");
	}

	
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Override
	public Result<TaskLog> find(Integer taskLogId, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		if (taskLogId==null)
			return ResultFactory.getFailResult("Unable to find TaskLog [null taskLogId]");
		
		TaskLog taskLog = taskLogDao.find(taskLogId);
		
		return ResultFactory.getSuccessResult(taskLog);
	}

	
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Override
	public Result<List<TaskLog>> findByUser(String username, Date startDate, Date endDate, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		if (startDate==null || endDate==null) {
            return ResultFactory.getFailResult("Start and end date are required for findByUser ");
		}
		
		User user = userDao.find(username);
		
		if (user==null) {
            return ResultFactory.getFailResult("Unable to find TaskLog for username=" + username + ". No such user");
		}
		
		List<TaskLog> taskLogs = taskLogDao.findByUser(user, startDate, endDate);
		
		
		return ResultFactory.getSuccessResult(taskLogs);
	}

}
