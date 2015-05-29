package domain;

import javax.json.JsonObjectBuilder;
import javax.persistence.*;

import java.util.List;

@Entity
@NamedQueries({
	@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c ORDER BY c.id ASC")
	
})

public class Company extends AbstractEntity implements EntityItem<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="company")
	private List<Project> projects;

	public Company() {
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setCompany(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setCompany(null);

		return project;
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
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public void addJson(JsonObjectBuilder builder) {
		
		builder.add("companyId", id).add("companyName", name);
		
	}

}