package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the task_log database table.
 * 
 */
@Entity
@Table(name="task_log")
@NamedQuery(name="TaskLog.findAll", query="SELECT t FROM TaskLog t")
public class TaskLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="task_date")
	private Date taskDate;

	@Column(name="task_minutes")
	private int taskMinutes;

	//bi-directional many-to-one association to Task
	@ManyToOne
	private Task task;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	public TaskLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTaskDate() {
		return this.taskDate;
	}

	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}

	public int getTaskMinutes() {
		return this.taskMinutes;
	}

	public void setTaskMinutes(int taskMinutes) {
		this.taskMinutes = taskMinutes;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}