package entity;

import java.time.LocalDate;
import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Long;
	private String name;
	private Agency agency;
	private LocalDate startDate;
	private LocalDate endDate;
	private SortedSet<Brand> brands;
	
	
	public int getLong() {
		return Long;
	}
	public void setLong(int l) {
		Long = l;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
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
	public SortedSet<Brand> getBrands() {
		return brands;
	}
	public void setBrands(SortedSet<Brand> brands) {
		this.brands = brands;
	}

	
	
}
