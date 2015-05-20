package service;

import java.util.List;

import domain.Task;
import vo.Result;

public interface TaskService {

	public Result<Task> store(Integer taskId, Integer projectId, String taskName, String actionUsername);

	public Result<Task> remove(Integer taskId, String actionUsername);

	public Result<Task> find(Integer taskId, String actionUsername);

	public Result<List<Task>> findAll(String actionUsername);
}
