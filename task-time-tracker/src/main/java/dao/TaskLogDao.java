package dao;

import java.util.Date;
import java.util.List;

import model.Task;
import model.TaskLog;
import model.User;

public interface TaskLogDao extends GenericDao<TaskLog, Integer> {
	
	public List<TaskLog> findByUser(User user, Date startDate, Date endDate);
	public long findTaskLogCountByTask(Task task);
	public long findTaskLogCountByUser(User user);
	

}
