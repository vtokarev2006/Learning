package dao;

import java.util.List;

import model.Task;

public interface TaskDao extends GenericDao<Task, Integer> {
	
	public List<Task> findAll(); 
	

}
