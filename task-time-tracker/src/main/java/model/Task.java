package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@ManyToOne
	private Project project;

	@OneToMany(mappedBy="task")
	private List<TaskLog> taskLogs;

	public Task() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<TaskLog> getTaskLogs() {
		return this.taskLogs;
	}

	public void setTaskLogs(List<TaskLog> taskLogs) {
		this.taskLogs = taskLogs;
	}

	public TaskLog addTaskLog(TaskLog taskLog) {
		getTaskLogs().add(taskLog);
		taskLog.setTask(this);

		return taskLog;
	}

	public TaskLog removeTaskLog(TaskLog taskLog) {
		getTaskLogs().remove(taskLog);
		taskLog.setTask(null);

		return taskLog;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (id != other.id)
			return false;
		return true;
	}

}