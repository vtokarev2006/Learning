package entity;

import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Agency {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany
	@JoinColumn(name="AGENCY_ID")
	private SortedSet<Client> clients;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SortedSet<Client> getClients() {
		return clients;
	}
	public void setClients(SortedSet<Client> clients) {
		this.clients = clients;
	}
	
	
	
	
	
	
	
}
