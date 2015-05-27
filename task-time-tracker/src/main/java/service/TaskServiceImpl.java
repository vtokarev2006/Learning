package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vo.Result;
import vo.ResultFactory;
import dao.ProjectDao;
import dao.TaskDao;
import dao.TaskLogDao;
import domain.Project;
import domain.Task;

public class TaskServiceImpl extends AbstractService implements TaskService {
	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	TaskLogDao taskLogDao;
	
	@Autowired
	ProjectDao projectDao;
	

	TaskServiceImpl (){
		super();
	}
	
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<Task> store(Integer taskId, Integer projectId, String taskName, String actionUsername) {

		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
		if (projectId==null)
			return ResultFactory.getFailResult("Unable to store task without a valid Project [null projectId]");
		
		Project project = projectDao.find(projectId);
		
		if (project==null)
			return ResultFactory.getFailResult("Unable to store task without a valid Project projectId="+projectId);

		
		Task task;
		
		
		if (project.getTasks() == null) {
			List<Task> tasks = new ArrayList<>();
			project.setTasks(tasks);
		}
		
		
		
		if (taskId==null) {
			
			task = new Task();
			task.setProject(project);
			project.getTasks().add(task);
			
		} else {
			task = taskDao.find(taskId);
			
			if (task==null)
				return ResultFactory.getFailResult("Unable to find task instance with ID="+ taskId);
			
			if(! task.getProject().equals(project)){

				Project oldProject = task.getProject();
				task.setProject(project);
				project.getTasks().add(task);
				oldProject.getTasks().remove(task);
			}
			
		}
		
		task.setName(taskName);
		
		
		if (task.getId() == null) {
			taskDao.persist(task);
			
		} else {
			taskDao.merge(task);
			
		}
		
		return ResultFactory.getSuccessResult(task);
		
		
	}

	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public Result<Task> remove(Integer taskId, String actionUsername) {

		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);

		if (!isAdmin(actionUsername)) 
			return ResultFactory.getFailResult(USER_NOT_ADMIN);
		
		if (taskId == null)
			return ResultFactory.getFailResult("Unable to remove Task [null taskId]");
		
		Task task = taskDao.find(taskId);
		
		if (task==null)
			return ResultFactory.getFailResult("Unable to load Project for removal with taskId=" + taskId);
		
		
		if (taskLogDao.findTaskLogCountByTask(task)>0)
			return ResultFactory.getFailResult("Unable to remove Task with taskId=" + taskId + " as valid task logs are assigned");

		
		taskDao.remove(task);
		String msg = "Task " + task.getName() + " was deleted by " + actionUsername;
		logger.info(msg);
		return ResultFactory.getSuccessResultMsg(msg);				
		
	}
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<Task> find(Integer taskId, String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		Task task = taskDao.find(taskId);
		return ResultFactory.getSuccessResult(task);
		
	}

	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	@Override
	public Result<List<Task>> findAll(String actionUsername) {
		
		if (!isValidUser(actionUsername))
			return ResultFactory.getFailResult(USER_INVALID);
		
		List<Task> tasks = taskDao.findAll();
		
		return ResultFactory.getSuccessResult(tasks); 
		
	}

}
