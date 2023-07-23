package org.pm.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Certificate {
	@Id
	private long id;
	private int year;
	@ManyToOne
	private College college;
	
	
	public Certificate() {
		super();
	}
	
	public Certificate(long id, int year, College college) {
		super();
		this.id = id;
		this.year = year;
		this.college = college;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
	}

	
}
