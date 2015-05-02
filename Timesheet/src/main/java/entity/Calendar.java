package entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Calendar {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private boolean isDayOff;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isDayOff() {
		return isDayOff;
	}
	public void setDayOff(boolean isDayOff) {
		this.isDayOff = isDayOff;
	}

	
}
