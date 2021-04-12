package com.onochieifedebe.pmtool.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;




@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq",
    allocationSize = 1,initialValue=1)
	private long employeeId;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},     //The Cascade type tells you what happens to the child class when the parent is deleted or altered.
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",joinColumns = @JoinColumn(name="employee_id"),inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Project> projects;
	
	private String firstName;
	private String lastName;
	private String email;
	
//<------------------------------------>
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}	
	
//<------------------------------------->	
	

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
