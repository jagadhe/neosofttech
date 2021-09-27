package com.jaga.Studentformapi.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Studentform {
	@Id
	private int id;
	private String first_name;
	private String last_name;
	private String password;
	private int mobile_number;
	private String email_address;

	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 @JoinTable(name="student_master", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="projid") )
	
	private Set<Project> projects;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getMobile_number() {
		return mobile_number;
	}


	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}


	public String getEmail_address() {
		return email_address;
	}


	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}


	public Set<Project> getProjects() {
		return projects;
	}


	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}








	

}
