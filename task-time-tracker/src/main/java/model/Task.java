package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

	//bi-directional many-to-one association to TaskLog
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

}