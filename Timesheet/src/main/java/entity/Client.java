package entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Client {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;

	@ManyToMany(fetch=FetchType.EAGER, mappedBy="clients")
	private Set<Agency> agencies;
	
	
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="client", cascade={CascadeType.ALL})
	@OrderBy("name ASC")
	private Set<Brand> brands;
	
	@Column(nullable=false)
	private LocalDate startDate;
	
	private LocalDate endDate;
	

	public Set<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(Set<Agency> agencies) {
		this.agencies = agencies;
	}

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


	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}
	
}
