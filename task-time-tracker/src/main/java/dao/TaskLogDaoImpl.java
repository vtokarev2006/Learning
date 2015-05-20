package dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.Task;
import domain.TaskLog;
import domain.User;

@Repository("TaskLogDao")
@Transactional
public class TaskLogDaoImpl extends GenericDaoImpl<TaskLog, Integer> implements TaskLogDao {

	public TaskLogDaoImpl() {
		super(TaskLog.class);
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<TaskLog> findByUser(User user, Date startDate, Date endDate) {
		return em.createNamedQuery("TaskLog.findByUser", type).
				setParameter("user", user).
				setParameter("startDate",startDate).
				setParameter("endDate",endDate)
				.getResultList();
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public long findTaskLogCountByTask(Task task) {
		
		return em.createNamedQuery("TaskLog.findTaskLogCountByTask", Long.class).
			setParameter("task", task).
			getSingleResult();
		
	}

	@Override
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public long findTaskLogCountByUser(User user) {
		return em.createNamedQuery("TaskLog.findTaskLogCountByUser", Long.class).
				setParameter("user",user).
				getSingleResult();
	}

}
