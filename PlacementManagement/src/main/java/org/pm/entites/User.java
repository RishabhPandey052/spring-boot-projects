package org.pm.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private long id;
	private String name;
	private String type;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(long id, String name, String type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
	}
	
	

}
