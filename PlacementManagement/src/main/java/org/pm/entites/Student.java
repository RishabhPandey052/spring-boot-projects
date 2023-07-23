package org.pm.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private long id;
	private String name;
	@ManyToOne
	private College college;
	private long roll;
	private String qualification;
	private String course;
	private int year;
	@OneToOne
	private Certificate certificate;
	private long hallTicketNo;
		
	public Student() {
		super();
	}
	
	public Student(long id, String name, College college, long roll, String qualification, String course, int year,
			Certificate certificate, long hallTicketNo) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.roll = roll;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.certificate = certificate;
		this.hallTicketNo = hallTicketNo;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public long getRoll() {
		return roll;
	}
	public void setRoll(long roll) {
		this.roll = roll;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}
	public long getHallTicketNo() {
		return hallTicketNo;
	}
	public void setHallTicketNo(long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", roll=" + roll + ", qualification="
				+ qualification + ", course=" + course + ", year=" + year + ", certificate=" + certificate
				+ ", hallTicketNo=" + hallTicketNo + "]";
	}
	
	
}
