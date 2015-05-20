package service;

import java.util.Date;
import java.util.List;

import domain.TaskLog;
import vo.Result;

public interface TaskLogService {

	public Result<TaskLog> store(Integer taskLogId, Integer taskId,	String username, String taskDescription, Date taskLogDate, int taskMinutes, String actionUsername);

	public Result<TaskLog> remove(Integer taskLogId, String actionUsername);

	public Result<TaskLog> find(Integer taskLogId, String actionUsername);

	public Result<List<TaskLog>> findByUser(String username, Date startDate, Date endDate, String actionUsername);

}
