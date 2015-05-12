package entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SecurityGroup {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToMany(fetch=FetchType.EAGER, mappedBy="securityGroups")
	private Set<User> user;


	
	
	
	
	

}
