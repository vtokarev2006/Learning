package domain;

import javax.json.JsonObjectBuilder;
import javax.persistence.*;

import java.util.List;


@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u ORDER BY u.firstName, u.lastName"),
	
	@NamedQuery(name="User.findByUsernamePassword", query="SELECT u FROM User u "
			+ "WHERE ((u.username=:username) or (u.email=:username)) and (u.password=:password)"),
			
	@NamedQuery(name="User.findByUsername", query="SELECT u FROM User u WHERE u.username=:username"),
	@NamedQuery(name="User.findByEmail", query="SELECT u FROM User u WHERE u.email=:email")
}) 

public class User extends AbstractEntity implements EntityItem<String>  {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	@Column(name="admin_role")
	private Character adminRole;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@OneToMany(mappedBy="user")
	private List<TaskLog> taskLogs;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Character getAdminRole() {
		return this.adminRole;
	}

	public void setAdminRole(Character adminRole) {
		this.adminRole = adminRole;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<TaskLog> getTaskLogs() {
		return this.taskLogs;
	}

	public void setTaskLogs(List<TaskLog> taskLogs) {
		this.taskLogs = taskLogs;
	}

	public TaskLog addTaskLog(TaskLog taskLog) {
		getTaskLogs().add(taskLog);
		taskLog.setUser(this);

		return taskLog;
	}

	public TaskLog removeTaskLog(TaskLog taskLog) {
		getTaskLogs().remove(taskLog);
		taskLog.setUser(null);

		return taskLog;
	}
	
	@Override
	public String getId() {
		return username;
	}

	public boolean isAdmin() {
		return adminRole == null ? false : adminRole.equals('Y');
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public void addJson(JsonObjectBuilder builder) {
		
		builder.add("username", username)
				.add("firstName", firstName)
				.add("lastName", lastName)
				.add("email", email)
				.add("adminRole", adminRole + "")
				.add("fullName", firstName + " " + lastName);		
	}


}